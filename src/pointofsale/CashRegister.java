

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
        try{
        receipt = new Receipt(storage, custNo, taxStrategy);
        }catch(IllegalArgumentException iae){
            output.displayErrors(iae);
        }
        
    }
    
    public void addNewItem(StorageStrategy storage, String prodId, Double qty){
        try{
        receipt.addLineItem(storage, prodId, qty);
        }catch(IllegalArgumentException iae){
            output.displayErrors(iae);
        }
    }
    
    public void finalizeSale(){
        try{
        output.displayReceipt(receipt);
        }catch(IllegalArgumentException iae){
            output.displayErrors(iae);
        }
    }
    
           

}
