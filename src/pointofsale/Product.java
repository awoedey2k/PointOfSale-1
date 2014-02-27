

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class Product {

    private String decription;
    private double price;
    private String sku;
    private DiscountStrategy DiscountStrategy;

    public Product(String decription, double price, String sku, DiscountStrategy DiscountStrategy) {
        this.decription = decription;
        this.price = price;
        this.sku = sku;
        this.DiscountStrategy = DiscountStrategy;
    }
    
    

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public DiscountStrategy getDiscountStrategy() {
        return DiscountStrategy;
    }

    public void setDiscount(DiscountStrategy Discount) {
        this.DiscountStrategy = DiscountStrategy;
    }
    
}
