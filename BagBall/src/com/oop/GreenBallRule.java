package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class GreenBallRule implements Rule {


    public static final int MAX_GREEN_BALLS_ALLOWED_IN_THE_BAG = 3;

    @Override
    public boolean appliesTo(Color color) {
        return color == Color.GREEN;
    }

    @Override
    public boolean evaluateAndApply(Ball ball, Bag bag) {
        if(bag.getBallsOfThisColor(Color.GREEN) >= MAX_GREEN_BALLS_ALLOWED_IN_THE_BAG){
            return false;
        }else{
            return true;
        }
    }
}
