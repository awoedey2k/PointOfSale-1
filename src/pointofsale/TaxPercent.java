

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class TaxPercent implements TaxStrategy{
    
    private double tax;
    
    public TaxPercent(double tax){
        
        this.tax = tax;
    }

    @Override
    public double getTaxAmount(double priceBeforeTaxes) {
        return priceBeforeTaxes * tax;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        if(tax < 0 || tax > 1){
            throw new IllegalArgumentException("Tax must be between 0 and 1");
        }
        this.tax = tax;
    }
    

}
