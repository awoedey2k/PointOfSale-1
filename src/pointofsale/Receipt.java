

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class Receipt {
    private StorageStrategy storage;
    private Customer customer;
    private LineItem[] lineItems = new LineItem[0];

    public Receipt(StorageStrategy storage, String customerNumber) {
        this.customer = findCustomer(customerNumber);
        this.storage = storage;
    }
    
    public void addLineItem(StorageStrategy storage, String prodId, double qty) {
        LineItem item = new LineItem(storage,prodId,qty);
        LineItem[] temp = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        lineItems = temp;
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
    
    
    
    

}
