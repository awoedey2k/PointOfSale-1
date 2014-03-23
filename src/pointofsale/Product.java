

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

    public void setDecription(String description) {
        if(description == null){
            throw new IllegalArgumentException("Description cannot be null");
        }
        
        this.decription = decription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if(sku == null || sku.length() != 3){
            throw new IllegalArgumentException("Sku must be 3 characters long");
        }
       
        this.sku = sku;
    }

    public DiscountStrategy getDiscountStrategy() {
        return DiscountStrategy;
    }

    public void setDiscount(DiscountStrategy Discount) {
        this.DiscountStrategy = Discount;
    }
    
    
    
}
