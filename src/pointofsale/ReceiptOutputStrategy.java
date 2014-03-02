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
public interface ReceiptOutputStrategy {
    
    public abstract void displayReceipt(Receipt receipt);
}
