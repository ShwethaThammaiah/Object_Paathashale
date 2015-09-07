package test;

import com.oop.Bag;
import com.oop.Ball;
import com.oop.BlueBallRule;
import com.oop.Color;
import com.oop.GreenBallRule;
import com.oop.MaxNumberOfBallsInTheBagRule;
import com.oop.RedBallRule;
import com.oop.Rule;
import com.oop.Size;
import com.oop.YellowBallRule;
import junit.framework.TestCase;
import org.testng.annotations.Test;

public class BagTest extends TestCase {

    @Test
    public void testAddLessThanTwelveBalls(){
        Bag bag = new Bag();
        Rule maxTwelveBalls = new MaxNumberOfBallsInTheBagRule();
        bag.addRule(maxTwelveBalls);
        Ball ball = new Ball(Color.BLUE,Size.SMALL);
        for(int i = 0; i <= 12 ; i ++){
            bag.addBall(ball);
        }
        Ball thirteenthBall = new Ball(Color.BLUE,Size.SMALL);
        assertEquals(false, bag.addBall(thirteenthBall));
    }

    @Test
    public void testCannotAddMoreThanThreeGreenBalls(){
        Bag bag = new Bag();
        Rule greenBallRule = new GreenBallRule();
        bag.addRule(greenBallRule);
        Ball ball1 = new Ball(Color.GREEN,Size.SMALL);
        Ball ball2 = new Ball(Color.GREEN,Size.SMALL);
        Ball ball3 = new Ball(Color.GREEN,Size.SMALL);
        Ball ball4 = new Ball(Color.GREEN,Size.SMALL);
        bag.addBall(ball1);
        bag.addBall(ball2);
        bag.addBall(ball3);
        assertEquals(false, bag.addBall(ball4));
    }

    @Test
    public void testRedBallsCannotBeMoreThanDoubleGreenBalls(){
        Bag bag = new Bag();
        Rule greenBallRule = new GreenBallRule();
        Rule redBallRule = new RedBallRule();
        bag.addRule(greenBallRule);
        bag.addRule(redBallRule);
        Ball greenBall1 = new Ball(Color.GREEN,Size.SMALL);
        Ball greenBall2 = new Ball(Color.GREEN,Size.SMALL);
        Ball redBall1 = new Ball(Color.RED,Size.SMALL);
        Ball redBall2 = new Ball(Color.RED,Size.SMALL);
        Ball redBall3 = new Ball(Color.RED,Size.SMALL);
        Ball redBall4 = new Ball(Color.RED,Size.SMALL);
        Ball redBall5 = new Ball(Color.RED,Size.SMALL);
        Ball redBall6 = new Ball(Color.RED,Size.SMALL);
        bag.addBall(greenBall1);
        bag.addBall(greenBall2);
        bag.addBall(redBall1);
        bag.addBall(redBall2);
        bag.addBall(redBall3);
        bag.addBall(redBall4);
        bag.addBall(redBall5);
        assertEquals(false, bag.addBall(redBall6));
    }

    @Test
    public void testNotMoreThanFortyPercentOfTheBallsAreYellow(){
        Bag bag = new Bag();
        Rule yellowBallRule = new YellowBallRule();
        Rule blueBallRule = new BlueBallRule();
        bag.addRule(yellowBallRule);
        bag.addRule(blueBallRule);
        Ball blueBall = new Ball(Color.BLUE,Size.SMALL);
        Ball yellowBall = new Ball(Color.YELLOW,Size.SMALL);
        for(int i=0; i < 6; i++)
        {
            bag.addBall(blueBall);
        }

        for(int i=0; i < 5; i++)
        {
            bag.addBall(yellowBall);
        }
        assertEquals(false, bag.addBall(yellowBall));
    }
}