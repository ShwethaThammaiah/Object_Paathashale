package com.company;

/**
 * Created by shwethathammaiah on 05/05/15.
 */
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

    public void priceHasChangedFor(Stock stock){
        System.out.println(name + " :Received new price update from " + stock.getName() + ". New price is " + stock.getPrice() );
    }
}
