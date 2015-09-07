package com.company;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StockTest extends TestCase {


    @Test
    public void testCallingSetStockPriceNotifiesStockExchangeOfNewPrice() throws Exception {

        StockExchange stockExchange = Mockito.mock(StockExchange.class);
        Stock stock = new Stock("Stock A", 100.0, stockExchange);
        stock.setPrice(34.11);
        Mockito.verify(stockExchange).changeInStockPrice(stock);
    }
}