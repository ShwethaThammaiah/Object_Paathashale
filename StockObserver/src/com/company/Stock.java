package com.company;

/**
 * Created by shwethathammaiah on 24/05/15.
 */
public class Stock {

    private String name;
    private double price;
    private StockExchange stockExchange;

    public Stock(String name, double price, StockExchange stockExchange) {
        this.name = name;
        this.price = price;
        this.stockExchange = stockExchange;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(this.price != price){
            this.price = price;
            stockExchange.changeInStockPrice(this);
        }
    }

    public StockExchange getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(StockExchange stockExchange) {
        this.stockExchange = stockExchange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        if (name != null ? !name.equals(stock.name) : stock.name != null) return false;
        if (stockExchange != null ? !stockExchange.equals(stock.stockExchange) : stock.stockExchange != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (stockExchange != null ? stockExchange.hashCode() : 0);
        return result;
    }
}
