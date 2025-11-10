package org.example;
public interface IProduct {

    // Method to calculate and return the total of all product sales
    int TotalSales(int[][] productSales);

    // Method to calculate and return the average value of all product sales
    double AverageSales(int[][] productSales);

    // Method to find and return the highest sales value
    int MaxSales(int[][] productSales);

    // Method to find and return the lowest sales value
    int MinSales(int[][] productSales);
}