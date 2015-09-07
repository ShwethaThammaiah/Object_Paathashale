package com.sahaj.video_store;

public class Movie extends DomainObject {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private PriceCode priceCode;

    public Movie(String name, PriceCode priceCode) {
        this.name = name;
        this.priceCode = priceCode;
    }

    public PriceCode priceCode() {
        return priceCode;
    }

    public void persist() {
        Registrar.add("Movies", this);
    }

    public static Movie get(String name) {
        return (Movie) Registrar.get("Movies", name);
    }

    public double charge(int daysRented) {

        return priceCode.charge(daysRented);
    }

    public double calculateFrequentRenterPoints(int daysRented) {

        return priceCode.calculateFrequentRenterPoints(daysRented);
    }

}
