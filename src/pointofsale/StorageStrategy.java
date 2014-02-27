

package pointofsale;

/**
 *
 * @author neilkenney
 */
public interface StorageStrategy {
    
    public abstract Product findProduct(String prodId);
    public abstract Customer findCustomer(String customerNumber);
}
