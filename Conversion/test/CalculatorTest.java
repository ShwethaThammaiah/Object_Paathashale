
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest extends TestCase {

    @Test
    public void testAdding500cmTo5mReturns10m(){
        Measure valueIncm = new Centimeter(500);
        Measure valueInm = new Meter(5);

        Measure result = Calculator.add(valueIncm,valueInm);

        Measure expectedResult = new Meter(10);

        Assert.assertTrue(expectedResult.getValue() == result.getValue());

    }

    @Test
    public void testConvertingKilometerToCentimeter()
    {
        Measure valueInkm = new Kilometer(2);


        Measure result = Calculator.ConvertToCentimeter(valueInkm);

        Measure expectedResult = new Centimeter(200000);
        Assert.assertTrue(expectedResult.getValue() == result.getValue());
    }

    @Test
    public void testConvertingMeterToCentimeterUsingGenericConverter()
    {
        Measure valueInkm = new Meter(2);


        Measure result = Calculator.ConvertToMeasure(valueInkm, new Centimeter());

        Measure expectedResult = new Centimeter(200);
        Assert.assertTrue(expectedResult.getValue() == result.getValue());
    }


    @Test
    public void testConvertingMeterToKilometerUsingGenericConverter()
    {
        Measure valueInkm = new Meter(2000);


        Measure result = Calculator.ConvertToMeasure(valueInkm, new Kilometer());

        Measure expectedResult = new Kilometer(2);
        Assert.assertTrue(expectedResult.getValue() == result.getValue());
    }

}