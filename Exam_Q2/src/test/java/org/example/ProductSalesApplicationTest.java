package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void testTotalSales() {
        // Arrange
        int[][] productSales = {
                {100, 200, 300},
                {150, 250, 100},
                {400, 500, 600}
        };
        ProductSales sales = new ProductSales();

        // Act
        int result = sales.TotalSales(productSales);

        // Assert
        assertEquals(2600, result, "Total sales should be 2600");
    }

    @Test
    public void testAverageSales() {
        // Arrange
        int[][] productSales = {
                {100, 200, 300},
                {150, 250, 100},
                {400, 500, 600}
        };
        ProductSales sales = new ProductSales();


        double result = sales.AverageSales(productSales);


        assertEquals(288.89, result, 0.01, "Average sales should be approximately 288.89");
    }
}
