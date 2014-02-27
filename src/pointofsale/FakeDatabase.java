

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class FakeDatabase implements StorageStrategy {
    
    private Customer[] customer = {
        new Customer("100", "Will Smith"),
        new Customer("200", "Avery Francis"),
        new Customer("300", "Kailey Bailey")
};
    
    private Product[] products = {
        new Product("Packer Hat", 19.95, "P123" , new DollarOffDiscount(5)),
        new Product("Brewers Hat", 24.95, "B123", new NoDiscount()),
        new Product("Bucks Hat", 15.95, "M123", new PercentOffDiscount(.10)),
        new Product("Admirals Hat", 12.95, "A123", new PercentOffDiscount(.05))
        
};

    @Override
    public Product findProduct(String prodId) {
       
        if(prodId == null || prodId.length() == 0){
            System.out.println("prodId cannot be null or have no length");
                    return null;
        }
        Product product = null;
        for(Product a : products){
            if(prodId.equals(a.getSku())){
                product = a;
                break;
            }
            
            
        }
        return product;
    }

    @Override
    public Customer findCustomer(String customerNumber) {
        
        Customer cust = null;
        for(Customer c : customer){
            if(customerNumber.equals(c.getCustomerNumber()))
                cust = c;
            break;
        }
        
        return cust;
         
    }
    
    
    
    
}
