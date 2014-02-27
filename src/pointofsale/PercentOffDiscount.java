

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class PercentOffDiscount implements DiscountStrategy {
    
    private double percent;
    

    public PercentOffDiscount(double percent) {
        setPercent(percent);
       
    }
    
    
    
    
    
    @Override
    public double getDiscount(double price, double qty){
        return price * qty * percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    
    

}
