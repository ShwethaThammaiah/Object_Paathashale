package com.company;

import junit.framework.TestCase;
import org.mockito.Mockito;

public class StockExchangeTest extends TestCase {

    public void testRegisterACompany()  {
        StockExchange testStockExchangeA = new StockExchange("Test Stock Exchange A");
        Stock testStockA = new Stock("Test Company A",100.0,testStockExchangeA);
        assertEquals(true,testStockExchangeA.registerAStock(testStockA));
    }

    public void testRegisteringACompanyThatIsAlreadyRegistered()  {
        StockExchange testStockExchangeA = new StockExchange("Test Stock Exchange A");
        Stock testStockA = new Stock("Test Company A",100.0,testStockExchangeA);
        assertEquals(true,testStockExchangeA.registerAStock(testStockA));
        assertEquals(false,testStockExchangeA.registerAStock(testStockA));
    }

    public void testUnregisterACompany() {
        StockExchange testStockExchangeA = new StockExchange("Test Stock Exchange A");
        Stock testStockA = new Stock("Test Company A",100.0,testStockExchangeA);
        assertEquals(true,testStockExchangeA.registerAStock(testStockA));
        assertEquals(true,testStockExchangeA.unregisterAStock(testStockA));
    }

    public void testUnregisterACompanyThatIsNotRegistered() {
        StockExchange testStockExchangeA = new StockExchange("Test Stock Exchange A");
        Stock testStockA = new Stock("Test Company A",100.0,testStockExchangeA);
        assertEquals(true,testStockExchangeA.registerAStock(testStockA));
        Stock testStockB  = new Stock("Test Company B",200.0,testStockExchangeA);
        assertEquals(false,testStockExchangeA.unregisterAStock(testStockB));
    }

    public void testRegisterASubscriber() throws Exception {
        StockExchange testStockExchangeA = new StockExchange("Test Stock Exchange A");
        Stock testStockA = new Stock("Test Company A",100.0,testStockExchangeA);
        assertEquals(true,testStockExchangeA.registerAStock(testStockA));
        Subscriber testSubscriberA = new Subscriber("Test Subscriber A");
        assertEquals(true,testStockExchangeA.registerASubscriber(testStockA,testSubscriberA));
    }

    public void testUnregisterASubscriber() throws Exception {
        StockExchange testStockExchangeA = new StockExchange("Test Stock Exchange A");
        Stock testStockA = new Stock("Test Company A",100.0,testStockExchangeA);
        assertEquals(true,testStockExchangeA.registerAStock(testStockA));
        Subscriber testSubscriberA = new Subscriber("Test Subscriber A");
        assertEquals(true,testStockExchangeA.registerASubscriber(testStockA,testSubscriberA));
        assertEquals(true,testStockExchangeA.unregisterASubscriber(testStockA,testSubscriberA));

    }

    public void testChangeInStockPriceNotifiesSubscribersOfNewPrice() throws Exception {

        StockExchange stockExchange = new StockExchange("Test Stock Exchange A");
        Stock stock = new Stock("Stock A", 100.0, stockExchange);
        Subscriber subscriber =  Mockito.mock(Subscriber.class);
        assertEquals(true,stockExchange.registerAStock(stock));
        assertEquals(true,stockExchange.registerASubscriber(stock,subscriber));
        stock.setPrice(34.11);

        Mockito.verify(subscriber).priceHasChangedFor(stock);
    }

}