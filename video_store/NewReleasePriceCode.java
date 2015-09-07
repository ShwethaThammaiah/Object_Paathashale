package com.sahaj.video_store;

/**
 * Created by shwethathammaiah on 23/03/15.
 */
public class NewReleasePriceCode implements PriceCode {
    @Override
    public double charge(int daysRented) {

        return  daysRented * 3;
    }

    @Override
    public double calculateFrequentRenterPoints(int daysRented) {
        if(daysRented > 1) {
            return 2;
        }else{
            return 0;
        }
    }
}
