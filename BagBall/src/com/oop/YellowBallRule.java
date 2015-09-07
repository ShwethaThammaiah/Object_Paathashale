package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class YellowBallRule implements Rule {

    public static final double FORTY_PERCENT = 0.4;

    @Override
    public boolean appliesTo(Color color) {
        return color == Color.YELLOW;
    }

    @Override
    public boolean evaluateAndApply(Ball ball, Bag bag) {
        int fortyPercent = (int)(FORTY_PERCENT * bag.getTotalNumberOfBallsInBag());
        if(bag.getBallsOfThisColor(Color.YELLOW) > fortyPercent){
            return false;
        }else{
            return true;
        }
    }
}
