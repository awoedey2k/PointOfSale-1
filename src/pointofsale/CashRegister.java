

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class CashRegister {
    
    private Receipt receipt;
    private ReceiptConsoleOutput output = new ReceiptConsoleOutput();
            
    
    
    public void startNewSale(StorageStrategy storage, String custNo){
        receipt = new Receipt(storage, custNo);
        
    }
    
    public void addNewItem(StorageStrategy storage, String prodId, Double qty){
        receipt.addLineItem(storage, prodId, qty);
    }
    
    public void finalizeSale(){
        output.displayReceipt(receipt);
    }
           

}
