

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class ReceiptConsoleOutput implements ReceiptOutputStrategy{
    
    
    @Override
    public void displayReceipt(Receipt receipt){
        
        System.out.println(receipt.getFinalReceipt());
        
        }

    @Override
    public void displayErrors(IllegalArgumentException ex) {
         
        System.out.println(ex.getMessage());
    }
    }


