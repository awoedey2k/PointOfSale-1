

package pointofsale;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author neilkenney
 */
public class Receipt {
    private StorageStrategy storage;
    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];
    private TaxStrategy taxStrategy;
    NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);

    public TaxStrategy getTaxStrategy() {
        return taxStrategy;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public Receipt(StorageStrategy storage, String customerNumber, TaxStrategy taxStrategy) {
        
        this.storage = storage;
        this.customer = findCustomer(customerNumber);
        this.taxStrategy = taxStrategy;
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
    
    public double getTotalBillDueBeforeTaxes(){
        
        double d = 0;
        
         for(int a = 0; a < lineItems.length; a++){
            d += lineItems[a].getProductTotal();
            
        }
         
         return d;
        
    }
    
    public double getTaxDue(){
        
        double tax;
        tax = taxStrategy.getTaxAmount(getTotalBillDueBeforeTaxes());
        
        return tax;
            
    }
    
    public double getFinalBill(){
        double bill;
        bill = getTaxDue() + getTotalBillDueBeforeTaxes();
        return bill;
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
            str += n.format(lineItems[a].getProduct().getPrice());
            str += "    ";
            str += n.format(lineItems[a].getDiscountAmount());
            str += "    ";
            str += n.format(lineItems[a].getProduct().getPrice() - lineItems[a].getDiscountAmount());
            str += "    ";
            str += n.format(lineItems[a].getProductTotal());
            str += '\n';
        }
        
        str += '\n';
        str += '\n';
        
        str += "Total Due : " + n.format(getTotalBillDueBeforeTaxes());
        str += '\n';
        str += "Taxes Due : " + n.format(getTaxDue());
        str += '\n';
        str += "Total With Taxes : " + n.format(getFinalBill());
        
        return str;
    }
    
    public String getFinalReceipt(){
        
        return getProductList();
        
    }
    
    private Customer findCustomer(String customerNumber) throws IllegalArgumentException{
        if(customerNumber.length() != 3){
            throw new IllegalArgumentException("Customer Number must be 3 numbers long");
        }
        char[] characters = customerNumber.toCharArray();
        for(char y : characters){
            if(!Character.isDigit(y)){
                throw new IllegalArgumentException("Customer number must be numeric");
            }
        }
        return storage.findCustomer(customerNumber);
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
