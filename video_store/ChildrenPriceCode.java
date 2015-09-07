package com.sahaj.video_store;

/**
 * Created by shwethathammaiah on 23/03/15.
 */
public class ChildrenPriceCode implements PriceCode {
    @Override
    public double charge(int daysRented) {
        double charge = 1.5;
        if (daysRented > 3)
            charge += (daysRented - 3) * 1.5;
      return charge;
    }

    @Override
    public double calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
