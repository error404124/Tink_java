package edu.hw3;

import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask6 {
    @Test
    void stockMarketTest1() {
        StockMarket.Stock a = new StockMarket.Stock(5);
        StockMarket.Stock b = new StockMarket.Stock(100);
        StockMarket.Stock c = new StockMarket.Stock(9);
        StockMarket asd = new StockMarket();
        asd.add(a); asd.add(b); asd.add(c);
        int answer = 100;
        assertThat(answer).isEqualTo(asd.mostValuableStock().cost());
    }
    @Test
    void stockMarketTest2() {
        StockMarket.Stock a = new StockMarket.Stock(5);
        StockMarket.Stock b = new StockMarket.Stock(100);
        StockMarket.Stock c = new StockMarket.Stock(9);
        StockMarket asd = new StockMarket();
        asd.add(a); asd.add(b); asd.add(c);
        asd.remove(b);
        int answer = 9;
        assertThat(answer).isEqualTo(asd.mostValuableStock().cost());
    }
    @Test
    void stockMarketTest3() {
        StockMarket.Stock a = new StockMarket.Stock(5);
        StockMarket.Stock b = new StockMarket.Stock(100);
        StockMarket.Stock c = new StockMarket.Stock(9);
        StockMarket asd = new StockMarket();
        asd.add(a); asd.add(b); asd.add(c);
        StockMarket.Stock d = new StockMarket.Stock(999);
        asd.add(d);
        int answer = 999;
        assertThat(answer).isEqualTo(asd.mostValuableStock().cost());
    }
}
