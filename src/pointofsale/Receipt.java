

package pointofsale;

import java.text.NumberFormat;

/**
 *
 * @author neilkenney
 */
public class Receipt {
    private StorageStrategy storage;
    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];

    public Receipt(StorageStrategy storage, String customerNumber) {
        
        this.storage = storage;
        this.customer = findCustomer(customerNumber);
    }
    
    public void addLineItem(StorageStrategy storage, String prodId, double qty) {
        LineItem item = new LineItem(storage,prodId,qty);
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        temp[lineItems.length] = item;
        lineItems = temp;
        
    }
    
    
    
    
    
    private String getProductPrice(){
        String str = "";
        for(int a = 0; a < lineItems.length; a++){
            str += lineItems[a].getProduct().getPrice();
            str += '\n';
        }
        
        return str;
    }
    
    public double getTotalBillDue(){
        
        double d = 0;
        
         for(int a = 0; a < lineItems.length; a++){
            d += lineItems[a].getProductTotal();
            
        }
         
         return d;
        
    }
    
    private String getProductList(){
        
        String str = "Kohls Department Store";
        str += '\n';
        str += '\n';
        str += "Customer: " + customer.getCustomerName();
        str += '\n';
        str += "Customer Number: " + customer.getCustomerNumber();
        str += '\n';
        str += '\n';
        
                
        for(int a = 0; a < lineItems.length; a++){
            str += lineItems[a].getProduct().getSku();
            str += "    ";
            str += lineItems[a].getProduct().getDecription();
            str += "    ";
            str += lineItems[a].getQty();
            str += "    ";
            str += lineItems[a].getProduct().getPrice();
            str += "    ";
            str += lineItems[a].getDiscountAmount();
            str += "    ";
            str += (lineItems[a].getProduct().getPrice() - lineItems[a].getDiscountAmount());
            str += "    ";
            str += lineItems[a].getProductTotal();
            str += '\n';
        }
        
        str += '\n';
        str += '\n';
        
        str += "Total Due: " + getTotalBillDue();
        
        return str;
    }
    
    public String getFinalReceipt(){
        
        return getProductList();
        
    }
    
    private Customer findCustomer(String CustomerNumber){
        return storage.findCustomer(CustomerNumber);
    }

    public StorageStrategy getStorage() {
        return storage;
    }

    public void setStorage(StorageStrategy storage) {
        this.storage = storage;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
    
    
    
    

}
