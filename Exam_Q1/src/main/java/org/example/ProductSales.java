package org.example;
public class ProductSales implements IProduct {

    @Override
    public int TotalSales(int[][] productSales) {
        // Variable to store the running total of all sales
        int totalSales = 0;

        // Loop through each row (year) in the 2D array
        // Each row has 3 quarterly values → Q1, Q2, Q3
        for (int i = 0; i < productSales.length; i++) {
            // Add all 3 quarter values from the current row directly
            totalSales += productSales[i][0] + productSales[i][1] + productSales[i][2];
        }

        // Return the total sum of sales
        return totalSales;
    }

    @Override
    public double AverageSales(int[][] productSales) {

        // Variable to store the total of all product sales
        double total = 0;

        // Variable to count the number of sale entries
        int count = 0;

        // Loop through all rows
        for (int i = 0; i < productSales.length; i++) {
            // Loop through each value inside the row (quarters)
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j]; // Add value to total
                count++;                    // Increase count of items
            }
        }

        // Return average by dividing total by number of entries
        return total / count;
    }


    @Override
    public int MaxSales(int[][] productSales) {

        // Initialize max value with the smallest possible integer
        int maxValue = Integer.MIN_VALUE;

        // Loop through each element in the 2D array
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {

                // If current value is greater than the tracked maximum → update
                if (productSales[i][j] > maxValue) {
                    maxValue = productSales[i][j];
                }
            }
        }

        // Return highest value found
        return maxValue;
    }

    @Override
    public int MinSales(int[][] productSales) {

        // Initialize min value with the largest possible integer
        int minValue = Integer.MAX_VALUE;

        // Loop through each element in the 2D array
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {

                // If current value is smaller than the tracked minimum → update
                if (productSales[i][j] < minValue) {
                    minValue = productSales[i][j];
                }
            }
        }

        // Return smallest value found
        return minValue;
    }
}