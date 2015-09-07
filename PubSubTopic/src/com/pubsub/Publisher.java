package com.pubsub;

public interface Publisher {

    public void registerASubscriberForATopic(Subscriber subscriber, Topic topic);
    public void unregisterASubscriberFromATopic(Subscriber subscriber, Topic topic);
    public void registerATopic(Topic topic);
    public void sendAMessageAboutATopicForRegisteredSubscribers(Topic topic, String message);
}
