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
        CashRegister cr = new CashRegister();
        cr.startNewSale(new FakeDatabase(), "100");
        cr.addNewItem(new FakeDatabase(), "P123", 1.0);
        cr.addNewItem(new FakeDatabase(), "A123", 2.0);
        cr.finalizeSale();
}
    
}
