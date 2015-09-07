package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class BlueBallRule implements Rule {

    @Override
    public boolean appliesTo(Color color) {
        return color == Color.BLUE;
    }

    @Override
    public boolean evaluateAndApply(Ball ball, Bag bag) {
        return true;
    }
}
