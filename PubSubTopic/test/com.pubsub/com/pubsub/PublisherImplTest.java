package com.pubsub;

import junit.framework.TestCase;

public class PublisherImplTest extends TestCase {


    public void testRegisterASubscriberForATopic() throws Exception {

        Subscriber subscriberShwetha = new Subscriber("Shwetha");
        Subscriber subscriberRishabh = new Subscriber("Rishabh");
        PublisherImpl publisher = new PublisherImpl();
        Topic baking = new Topic("Baking");
        Topic dogs = new Topic("Dogs");
        Topic ferrisWheel = new Topic("Ferris Wheel");
        publisher.registerATopic(baking);
        publisher.registerATopic(dogs);
        publisher.registerATopic(ferrisWheel);
        publisher.registerASubscriberForATopic(subscriberShwetha, baking);
        publisher.registerASubscriberForATopic(subscriberShwetha,dogs);
        publisher.registerASubscriberForATopic(subscriberRishabh,dogs);
        publisher.registerASubscriberForATopic(subscriberRishabh,ferrisWheel);
        publisher.sendAMessageAboutATopicForRegisteredSubscribers(baking,"There's a new baking class!");
        publisher.sendAMessageAboutATopicForRegisteredSubscribers(dogs,"There's a new dog cuddling class!");
        publisher.sendAMessageAboutATopicForRegisteredSubscribers(ferrisWheel,"The ferris wheel starts working this Saturday!");

    }
}