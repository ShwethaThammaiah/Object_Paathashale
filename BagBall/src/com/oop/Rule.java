package com.oop;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public interface Rule {

    public boolean appliesTo(Color color);

    public boolean evaluateAndApply(Ball ball, Bag bag);

}
