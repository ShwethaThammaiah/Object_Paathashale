/**
 * Created by shwethathammaiah on 07/06/15.
 */
public class Calculator {

    public static Measure add(Measure valueIncm, Measure valueInm) {

        double valueInMeter = valueIncm.convertToMeter().getValue() + valueInm.convertToMeter().getValue();
        return new Meter(valueInMeter);
    }

    public static Measure ConvertToCentimeter(Measure valueInkm) {

        Measure valueinMeters = valueInkm.convertToMeter();

        Measure returnedCentimeters = new Centimeter();

        return (returnedCentimeters.convertFromMeter(valueinMeters));


    }

    public static Measure ConvertToMeasure(Measure valueInkm, Measure valueInExpectedUnit) {

        Measure valueinMeters = valueInkm.convertToMeter();

        return (valueInExpectedUnit.convertFromMeter(valueinMeters));


    }
}
