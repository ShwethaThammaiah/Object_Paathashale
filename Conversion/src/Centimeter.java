/**
 * Created by shwethathammaiah on 07/06/15.
 */
public class Centimeter extends Measure {

    private static final double conversionFactor = 0.01;

    public Centimeter(double value) {
        super(value);
    }

    public Centimeter(){}

    @Override
    protected double getConversionFactor() {
        return conversionFactor;
    }


}
