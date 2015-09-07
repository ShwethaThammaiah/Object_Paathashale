package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class RedBallRule implements Rule{

    public static final int MULTIPLYING_FACTOR = 2;

    @Override
    public boolean appliesTo(Color color) {
        return color == Color.RED;
    }

    @Override
    public boolean evaluateAndApply(Ball ball, Bag bag) {
       int numberOfGreenBallsInTheBag = bag.getBallsOfThisColor(Color.GREEN);
       int numberOfRedBallsInTheBag = bag.getBallsOfThisColor(Color.RED);
        if(numberOfRedBallsInTheBag > ( MULTIPLYING_FACTOR * numberOfGreenBallsInTheBag)){
            return false;
        }else {
            return true;
        }
    }
}
