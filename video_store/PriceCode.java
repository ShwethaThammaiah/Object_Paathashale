package com.sahaj.video_store;

/**
 * Created by shwethathammaiah on 23/03/15.
 */
public interface PriceCode {

    double charge(int daysRented);

    double calculateFrequentRenterPoints(int daysRented);

}
