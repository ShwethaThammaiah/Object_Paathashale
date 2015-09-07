package com.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shwethathammaiah on 27/05/15.
 */
public class Bag {

    private List<Ball> balls;
    private List<Rule> rules;

    public Bag(){
        balls = new ArrayList<Ball>();
        rules = new ArrayList<Rule>();
    }

    public void addRule(Rule rule){
        rules.add(rule);
    }

    public boolean addBall(Ball ball){

        for(Rule rule : rules){
            if(rule.appliesTo(ball.getColor())){
                if(rule.evaluateAndApply(ball, this)){
                    balls.add(ball);
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public int getBallsOfThisColor(Color color) {
        int count = 0;
        for(Ball ball : balls){
            if(ball.getColor() == color){
                ++count;
            }
        }
        return count;
    }

    public int getTotalNumberOfBallsInBag() {
        return balls.size();
    }
}
