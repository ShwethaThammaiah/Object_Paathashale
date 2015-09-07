package com.pubsub;

public class Subscriber {

    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber that = (Subscriber) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void messageForTopic(Topic topic, String message){
        System.out.println(name + " :Received new message about " + topic.getTopicName());
        System.out.println(name + " :The message says... " + message);
    }

}
