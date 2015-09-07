/**
 * Created by shwethathammaiah on 07/06/15.
 */
public class Kilometer extends Measure {

    private static final double conversionFactor = 1000;

    public Kilometer(double value) {
        super(value);
    }

    public Kilometer(){}

    @Override
    protected double getConversionFactor() {
        return conversionFactor;
    }

}
