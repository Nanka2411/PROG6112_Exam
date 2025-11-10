package org.example;

public class ProductSales implements IProductSales {
    // 2D array to hold sales data for each year and each product
    private int[][] salesData = {
            {300, 150, 700},   // Year 1 sales for 3 products
            {250, 200, 600}    // Year 2 sales for 3 products
    };

// ------------------- METHODS -------------------

    // Calculates the total sales of all products over all years
    @Override
    public int getTotalProductSales() {
        int total = 0;                     // Initialize total counter
        for (int[] year : salesData) {     // Loop through each year
            for (int sale : year) {        // Loop through each sale in the year
                total += sale;             // Add sale to total
            }
        }
        return total;                      // Return total sales
    }

    // Counts the number of sales greater than a specified limit
    @Override
    public int getSalesOverLimit(int limit) {
        int count = 0;                     // Counter for sales over the limit
        for (int[] year : salesData) {     // Loop through each year
            for (int sale : year) {        // Loop through each sale in the year
                if (sale > limit) {        // Check if sale exceeds the limit
                    count++;               // Increment counter
                }
            }
        }
        return count;                      // Return number of sales over the limit
    }

    // Counts the number of sales less than a specified limit
    @Override
    public int getSalesUnderLimit(int limit) {
        int count = 0;                     // Counter for sales under the limit
        for (int[] year : salesData) {     // Loop through each year
            for (int sale : year) {        // Loop through each sale in the year
                if (sale < limit) {        // Check if sale is below the limit
                    count++;               // Increment counter
                }
            }
        }
        return count;                      // Return number of sales under the limit
    }

    // Returns the number of years of sales data (number of rows in the 2D array)
    @Override
    public int getProductsProcessed() {
        return salesData.length;           // Each row represents a year
    }

    // Calculates the average sale across all products and years
    @Override
    public double getAverageSales() {
        int total = getTotalProductSales(); // Get total sales
        int count = 0;                       // Counter for total number of sales
        for (int[] year : salesData) {       // Loop through each year
            count += year.length;            // Add number of products in the year
        }
        return (double) total / count;       // Divide total sales by number of sales to get average
    }
}