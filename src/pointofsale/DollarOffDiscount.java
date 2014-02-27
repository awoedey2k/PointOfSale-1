

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class DollarOffDiscount implements DiscountStrategy {
    
    private double dollarOff;
    
    public DollarOffDiscount(double dollarOff) {
        setDollarOff(dollarOff);
        
    }

    public double getDollarOff() {
        return dollarOff;
    }

    public void setDollarOff(double dollarOff) {
        this.dollarOff = dollarOff;
    }
    
    

    @Override
    public double getDiscount(double price, double qty) {
        return dollarOff;
    }

   
    

}
