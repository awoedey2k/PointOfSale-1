/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class PointOfSale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Receipt aa = new Receipt(new FakeDatabase(), "100");
        
        aa.addLineItem(new FakeDatabase(), "P123", 1);
        aa.addLineItem(new FakeDatabase(), "A123", 1);
        aa.addLineItem(new FakeDatabase(), "P123", 3);
        
        ReceiptConsoleOutput bb = new ReceiptConsoleOutput();
        
        bb.displayReceipt(aa);
    }
    
}
