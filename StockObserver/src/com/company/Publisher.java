package com.company;

import com.company.Subscriber;

/**
 * Created by shwethathammaiah on 05/05/15.
 */
public interface Publisher {

    public boolean registerAStock(Stock stock) ;
    public boolean unregisterAStock(Stock stock);
    public boolean registerASubscriber(Stock stock,Subscriber subscriber);
    public boolean unregisterASubscriber(Stock stock,Subscriber subscriber);
}
