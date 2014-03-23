

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class LineItem {
    private StorageStrategy storage;
    private Product product;
    private double qty;
    
    
    public LineItem(StorageStrategy storage, String prodId, double qty){
        this.storage = storage;
        this.product = findProduct(prodId);
        setQty(qty);
    }
    
    private Product findProduct(String prodId){
        return storage.findProduct(prodId);
    }

    public double getDiscountAmount(){
        return product.getDiscountStrategy().getDiscount(product.getPrice(), qty);
    }
    
    public double getProductTotal(){
        return (product.getPrice() - product.getDiscountStrategy().getDiscount(product.getPrice(), qty)) * qty ;
    }
    
    

    public StorageStrategy getStorage() {
        return storage;
    }

    public void setStorage(StorageStrategy storage) {
        this.storage = storage;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
    
 
}
