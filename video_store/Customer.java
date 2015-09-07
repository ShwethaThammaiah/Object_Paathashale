package com.sahaj.video_store;

import java.util.ArrayList;
import java.util.List;

public class Customer extends DomainObject {
  private List<Rental> rentals = new ArrayList<Rental>();

  public Customer(String name) {
    this.name = name;
  }

  public String statement() {
    double totalCharge = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + name() + "\n";
    for (Rental rental : rentals) {

        totalCharge += rental.tape().movie().charge(rental.daysRented());
        frequentRenterPoints += rental.tape().movie().calculateFrequentRenterPoints(rental.daysRented());


        //show figures for this rental
      result += "\t" + rental.tape().movie().name() + "\t" + String.valueOf(rental.tape().movie().charge(rental.daysRented())) + "\n";
    }

    //add footer lines
    result += "Amount owed is " + String.valueOf(totalCharge) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    return result;

  }

    public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public static Customer get(String name) {
    return (Customer) Registrar.get("Customers", name);
  }

  public void persist() {
    Registrar.add("Customers", this);
  }
}