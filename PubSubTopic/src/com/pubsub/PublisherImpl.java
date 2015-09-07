package com.pubsub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublisherImpl implements Publisher {

    private Map<Topic,List<Subscriber>> topicSubscribers = new HashMap<Topic, List<Subscriber>>();

    @Override
    public void registerASubscriberForATopic(Subscriber subscriber, Topic topic) {
        List<Subscriber> subscribersForThisTopic;
        if(topicSubscribers.containsKey(topic)){
            subscribersForThisTopic = topicSubscribers.get(topic);
            subscribersForThisTopic.add(subscriber);
        }else{
            subscribersForThisTopic = new ArrayList<Subscriber>();
            subscribersForThisTopic.add(subscriber);
            topicSubscribers.put(topic,subscribersForThisTopic);
        }
    }

    @Override
    public void unregisterASubscriberFromATopic(Subscriber subscriber, Topic topic) {
        List<Subscriber> subscribersForThisTopic;
        if(topicSubscribers.containsKey(topic)){
            subscribersForThisTopic = topicSubscribers.get(topic);
            subscribersForThisTopic.remove(subscriber);
        }
    }

    @Override
    public void registerATopic(Topic topic) {
        List<Subscriber> subscribersForThisTopic = new ArrayList<Subscriber>();
        topicSubscribers.put(topic,subscribersForThisTopic);
    }

    @Override
    public void sendAMessageAboutATopicForRegisteredSubscribers(Topic topic, String message) {
        if(topicSubscribers.containsKey(topic)){
            List<Subscriber> subscribersForThisTopic = topicSubscribers.get(topic);
            for(Subscriber subscriber : subscribersForThisTopic){
               subscriber.messageForTopic(topic,message);
            }
        }

    }
}
