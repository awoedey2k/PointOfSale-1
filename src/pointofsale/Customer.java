

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class Customer {
    private String customerNumber;
    private String customerName;

    public Customer(String customerNumber, String customerName) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
    }
    
    

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        
        if(customerNumber == null || customerNumber.length() != 3){
            throw new IllegalArgumentException("Customer number must be 3 characters long");
        }
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        
        if(customerName == null || customerName.length() > 0){
            throw new IllegalArgumentException("Customer Name must be at least 1 character");
        }
        char[] a = customerName.toCharArray();
        
        for(char b : a){
            if(!Character.isAlphabetic(b)){
                throw new IllegalArgumentException("Name must be alphabetic");
            }
        }
        
        this.customerName = customerName;
    }
    
    

}
