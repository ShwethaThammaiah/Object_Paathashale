package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class MaxNumberOfBallsInTheBagRule implements Rule{

    public static final int MAX_NUMBER_OF_BALLS_ALLOWED_IN_THE_BAG = 12;

    @Override
    public boolean appliesTo(Color color) {
        return true;
    }

    @Override
    public boolean evaluateAndApply(Ball ball, Bag bag) {
        if(bag.getTotalNumberOfBallsInBag() > MAX_NUMBER_OF_BALLS_ALLOWED_IN_THE_BAG){
            return false;
        }else{
            return true;
        }
    }
}
