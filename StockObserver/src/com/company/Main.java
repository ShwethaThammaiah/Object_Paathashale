package com.company;

public class Main {

    public static void main(String[] args) {

        StockExchange stockExchange = new StockExchange("Bombay Stock Exchange");

        Stock wiproStock = new Stock("Wipro",100.0,stockExchange);

        Stock infosysStock = new Stock("Infosys", 200.0,stockExchange);

        stockExchange.registerAStock(wiproStock);
        stockExchange.registerAStock(infosysStock);

        Subscriber subscriberShwetha = new Subscriber("Shwetha");
        Subscriber subscriberRishabh = new Subscriber(("Rishabh"));

        stockExchange.registerASubscriber(wiproStock,subscriberShwetha);
        stockExchange.registerASubscriber(infosysStock,subscriberShwetha);
        stockExchange.registerASubscriber(infosysStock,subscriberRishabh);


        wiproStock.setPrice(200.0);
        infosysStock.setPrice(125.0);

        stockExchange.unregisterASubscriber(infosysStock,subscriberShwetha);

        wiproStock.setPrice(167.0);
        infosysStock.setPrice(175.0);

    }
}
