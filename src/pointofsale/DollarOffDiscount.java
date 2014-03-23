

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
        
        if(dollarOff < 0){
            throw new IllegalArgumentException("Discount must be greater than 0");
        }
        this.dollarOff = dollarOff;
    }
    
    

    @Override
    public double getDiscount(double price, double qty) {
        return dollarOff;
    }

   
    

}
