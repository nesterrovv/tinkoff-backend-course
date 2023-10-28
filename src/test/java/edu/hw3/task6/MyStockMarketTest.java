package edu.hw3.task6;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MyStockMarketTest {

    StockMarket myStockMarket;

    @BeforeEach
    void initNewStockMarket() {
        myStockMarket =  new MyStockMarket();
    }

    @Test
    void testEmpty() {
        // Assert
        assertThat(myStockMarket.size()).isEqualTo(0);
    }

    @Test
    void testAddition() {
        // Arrange
        Stock stock = new Stock("TSPX", 7.51);
        // Act
        boolean added = myStockMarket.add(stock);
        // Assert
        assertThat(added).isTrue();
    }

    @Test
    void testRemoving() {
        // Arrange
        Stock stock = new Stock("TSPX", 7.51);
        myStockMarket.add(stock);
        // Act
        boolean removed = myStockMarket.remove(stock);
        // Assert
        assertThat(removed).isTrue();
    }

    @Test
    void testRemovingWithDecreaseSize() {
        // Arrange
        List<Stock> stocks = List.of(
            new Stock("TSPX", 9.51),
            new Stock("IM_WAITING_FOR_TSPX_UNLOCK", 8.51),
            new Stock("I_HOPE", 7.51)
        );
        for (Stock stock : stocks) {
            myStockMarket.add(stock);
        }
        // Act
        myStockMarket.remove(myStockMarket.mostValuableStock());
        // Assert
        assertThat(myStockMarket.size()).isEqualTo(stocks.size() - 1);
    }

    @Test
    void testRemovingTheLastStock() {
        // Arrange
        Stock singleStock = new Stock("TSPX", 7.51);
        myStockMarket.add(singleStock);
        // Act
        myStockMarket.remove(singleStock);
        // Assert
        assertThat(myStockMarket.size()).isEqualTo(0);
    }

    @Test
    void testRemovingFromTheEmptyStockMarket() {
        // Arrange & Act
        boolean removed = myStockMarket.remove(myStockMarket.mostValuableStock());
        // Assert
        assertThat(removed).isFalse();
    }

    @Test
    void testMostValuableStock() {
        // Arrange & Act
        List<Stock> stocks = List.of(
            new Stock("TSPX", 7.51),
            new Stock("TSPX_NUMBER_TWO", 8.51),
            new Stock("TSPX_NUMBER_THREE", 9.51)
        );
        for (Stock stock : stocks) {
            myStockMarket.add(stock);
        }
        int expectedStockId = 2;
        // Assert
        assertThat(myStockMarket.mostValuableStock()).isEqualTo(stocks.get(expectedStockId));
    }

}
