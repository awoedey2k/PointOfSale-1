

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class NoDiscount implements DiscountStrategy {

    
    
    @Override
    public double getDiscount(double price, double qty) {
        return 0;
    }

    

    

}
