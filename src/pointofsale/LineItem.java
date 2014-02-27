

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class LineItem {
    private Product product;
    private double qty;
    

    public double getDiscountAmount(){
        return product.getDiscountStrategy().getDiscount(product.getPrice(), qty);
    }
    
}
