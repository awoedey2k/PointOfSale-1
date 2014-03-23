

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class CashRegister {
    
    private Receipt receipt;
    private ReceiptOutputStrategy output;
            
    
    public CashRegister(ReceiptOutputStrategy output){
        this.output = output;
    }
    
    
    public void startNewSale(StorageStrategy storage, String custNo, TaxStrategy taxStrategy){
        if(custNo == null || custNo.length() != 3){
            throw new IllegalArgumentException("Customer Number must be 3 digits long");
        }
        receipt = new Receipt(storage, custNo, taxStrategy);
        
    }
    
    public void addNewItem(StorageStrategy storage, String prodId, Double qty){
        receipt.addLineItem(storage, prodId, qty);
    }
    
    public void finalizeSale(){
        output.displayReceipt(receipt);
    }
    
    public void printExceptions(IllegalArgumentException ex){
        output.displayErrors(ex);
    }
           

}
