package com.sahaj.testing;

import org.junit.Test;

import static org.junit.Assert.*;


public class TweetTest {

    @Test
    public void shouldReturnWhoTweeted(){
        Tweet shwethaTweeted = new Tweet("shwetha", "I'm like a bird");

        assertEquals("shwetha",shwethaTweeted.whoTweeted());
    }

    @Test
    public void shouldReturnTweetCorrectly(){
        Tweet shwethaTweeted = new Tweet("shwetha", "I like to fly away");

        assertEquals("I like to fly away",shwethaTweeted.getTweet());
    }

    @Test
    public void shouldReturnTrueIfTheTweetsAreTheSame(){
        Tweet shwethaTweeted = new Tweet("shwetha", "I like to fly away");
        Tweet shwethaTweetedAgain = new Tweet("shwetha", "I like to fly away");
        assertEquals(true,shwethaTweeted.equals(shwethaTweetedAgain));
    }

    @Test
    public void shouldReturnFalseIfTheTweetsAreTheSame(){
        Tweet shwethaTweeted = new Tweet("shwetha", "I like to fly away");
        Tweet shwethaTweetedAgain = new Tweet("shwetha", "I don't know where my home is");
        assertEquals(false,shwethaTweeted.equals(shwethaTweetedAgain));
    }
}