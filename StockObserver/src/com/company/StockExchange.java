package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shwethathammaiah on 24/05/15.
 */
public class StockExchange implements Publisher {


    private String name;
    private Map<Stock,List<Subscriber>> companySubscribers;

    public StockExchange(String name){
        this.name = name;
        companySubscribers = new HashMap<Stock, List<Subscriber>>();
    }

    @Override
    public boolean registerAStock(Stock stock)  {
        if(companySubscribers.containsKey(stock)){
            System.out.println("Stock for " + stock.getName() + " is already registered");
            return false;
        }else{
            List<Subscriber> subscribers = new ArrayList<Subscriber>();
            companySubscribers.put(stock,subscribers);
            return true;
        }

    }

    @Override
    public boolean unregisterAStock(Stock stock) {
        if(companySubscribers.containsKey(stock)){
            companySubscribers.remove(stock);
            return true;
        }else{
            System.out.println("Stock" + stock.getName() + " is not registered");
            return false;
        }

    }

    @Override
    public boolean registerASubscriber(Stock stock, Subscriber subscriber) {
        if(companySubscribers.containsKey(stock)){
            List<Subscriber> subscribersForThisCompany = companySubscribers.get(stock);
            if(subscribersForThisCompany.add(subscriber)) {
                System.out.println("Added " + subscriber.getName() + " to the subscriber list for " + stock.getName());
                return true;
            }
        }else{
            System.out.println("This stock is not registered with the Stock Exchange");
            return false;
        }

        return false;
    }

    @Override
    public boolean unregisterASubscriber(Stock stock, Subscriber subscriber) {
        if(companySubscribers.containsKey(stock)){
            List<Subscriber> subscribersForThisCompany = companySubscribers.get(stock);
            if(subscribersForThisCompany.remove(subscriber)){
                System.out.println("Removed " + subscriber.getName() + " from the subscriber list for " + stock.getName());
                return true;
            }else{
                System.out.println("Unable to remove " + subscriber.getName() + " from the subscriber list for " + stock.getName());
                return false;
            }

        }else{
            System.out.println("This stock is not registered with the Stock Exchange");
            return false;
        }
    }


    public void changeInStockPrice(Stock stock) {
        if(companySubscribers.containsKey(stock)){
            notifySubscribersOfChangeInPrice(stock);
        }else{
            System.out.println("This stock is not registered with the Stock Exchange");
        }

    }

    private void notifySubscribersOfChangeInPrice(Stock stock) {

            List<Subscriber> subscribersForThisCompany = companySubscribers.get(stock);
            for(Subscriber subscriber :subscribersForThisCompany){
                subscriber.priceHasChangedFor(stock);
            }
    }


}
