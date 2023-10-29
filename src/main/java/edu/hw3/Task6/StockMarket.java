package edu.hw3.Task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockMarket {
    public PriorityQueue<Stock> stockQuque = new PriorityQueue<>(Comparator.comparing(Stock::cost).reversed());

    public void add(Stock stock) {
        stockQuque.add(stock);
    }

    public void remove(Stock stock) {
        stockQuque.remove(stock);
    }

    public Stock mostValuableStock() {
        return stockQuque.peek();
    }

    public record Stock(int cost) {
    }
}
