

package pointofsale;

/**
 *
 * @author neilkenney
 */
public class TaxNone implements TaxStrategy {

    @Override
    public double getTaxAmount(double priceBeforeTaxes) {
        return 0;
    }

}
