

package pointofsale;

import javax.swing.JOptionPane;

/**
 *
 * @author neilkenney
 */
public class ReceiptJOptionPaneOutput implements ReceiptOutputStrategy {

    @Override
    public void displayReceipt(Receipt receipt) {
         
        JOptionPane.showMessageDialog(null, receipt.getFinalReceipt());
    }

}
