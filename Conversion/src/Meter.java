/**
 * Created by shwethathammaiah on 07/06/15.
 */
public class Meter extends Measure {

    private static final double conversionFactor = 1;

    public Meter(double value) {
        super(value);
    }

    public Meter(){}

    @Override
    protected double getConversionFactor() {
        return conversionFactor;
    }


}
