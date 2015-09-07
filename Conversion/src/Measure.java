/**
 * Created by shwethathammaiah on 07/06/15.
 */
public abstract class  Measure {

    private double value;


    public Measure(double value){
        this.value = value;
    }

    public Measure(){};

    public double getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    protected abstract double getConversionFactor();


    public Measure convertToMeter() {
        return new Meter(this.getValue() * getConversionFactor());
    }

    public  Measure convertFromMeter(Measure inMeters) {
        return new Centimeter((inMeters.getValue()/getConversionFactor()));
    }

}
