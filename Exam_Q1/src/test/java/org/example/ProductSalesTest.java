package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTest {

    @Test
    public void testTotalSales() {

        // Arrange: Creates a 2D array of product sales and a ProductSales object
        // Each row represents a set of sales values
        int[][] productSales = {
                {100, 200, 300},
                {150, 250, 100},
                {400, 500, 600}
        };

        ProductSales sales = new ProductSales();

        // Act: Call the TotalSales method to calculate total sales
        int result = sales.TotalSales(productSales);

        // Assert: Checks that the total matches the expected value (2600)
        // If incorrect message "Total sales should be 2600" will display
        assertEquals(2600, result, "Total sales should be 2600");
    }

    @Test
    public void testAverageSales() {

        // Arrange: Creates a sample product for sales data
        int[][] productSales = {
                {100, 200, 300},
                {150, 250, 100},
                {400, 500, 600}
        };

        ProductSales sales = new ProductSales();

        // Act: Calculate the average from the ProductSales method
        double result = sales.AverageSales(productSales);

        // Assert:
        // Checks if result is approximately 288.89
        // 0.01 indicates the allowed difference (tolerance)
        assertEquals(288.89, result, 0.01, "Average sales should be approximately 288.89");
    }
}