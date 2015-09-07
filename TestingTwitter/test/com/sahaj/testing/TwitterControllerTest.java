package com.sahaj.testing;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class TwitterControllerTest extends TestCase {

    Tweet supermanTweeted;
    Tweet batmanTweeted;
    Twitter twitterMocked;
    TwitterController twitterController;

    @Before
    public void setUp() throws Exception {

        //Real objects used for Collaborator
        supermanTweeted = new Tweet("superman", "I'm not a bird");
        batmanTweeted = new Tweet("batman","I'm a bat, not a bird. I fly but I do not tweet or chirp");

        //Mock the Twitter interface
        twitterMocked = mock(Twitter.class);

        //This is the class that I have created and I want to test it
        twitterController = new TwitterController(twitterMocked);
    }

    @Test
    public void testReadFeedAndTransformFeed(){

        when(twitterMocked.readFeed()).thenReturn("@superman I'm not a bird|@batman I'm a bat, not a bird. I fly but I do not tweet or chirp");
        assertEquals(asList(supermanTweeted, batmanTweeted), twitterController.readFeed());
    }

    @Test
    public void testASuccessfulPostToTwitterShouldReturnSuccessStatus() {
        //Mock the Twitter interface
        Twitter twitterMocked = mock(Twitter.class);

        //This is the class that I have created and I want to test it
        TwitterController twitterController = new TwitterController(twitterMocked);

        String message = "Superheroes are people too!";
        when(twitterMocked.post(any(String.class))).thenReturn(true);

        boolean posted = twitterController.post(message);

        assertTrue(posted);
        verify(twitterMocked).post(message);
    }

    @Test
    public void testAFailedPostToTwitterShouldReturnFailedStatus() {
        //Mock the Twitter interface
        Twitter twitterMocked = mock(Twitter.class);

        //This is the class that I have created and I want to test it
        TwitterController twitterController = new TwitterController(twitterMocked);
        String message = "They are just super people.....";
        when(twitterMocked.post(any(String.class))).thenReturn(false);

        boolean posted = twitterController.post(message);

        assertFalse(posted);
    }
}