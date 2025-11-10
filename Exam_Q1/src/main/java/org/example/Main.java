package org.example;
public class Main {
    public static void main(String[] args) {

        // 2-Dimensional array storing product sales:
        // Row 0 = Year 1 → Q1, Q2, Q3
        // Row 1 = Year 2 → Q1, Q2, Q3
        int[][] QUARTERS = { {300, 150, 700}, {250, 200, 600} };

        // Print report header
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("---------------------------------------");

        // Create an object of ProductSales to access calculation methods
        ProductSales productSales = new ProductSales();

        // Display calculated total sales
        System.out.println("Total Sales: " + productSales.TotalSales(QUARTERS));

        // Display calculated average sales
        System.out.println("Average Sales: " + productSales.AverageSales(QUARTERS));

        // Display highest sales value found
        System.out.println("Maximum Sales: " + productSales.MaxSales(QUARTERS));

        // Display lowest sales value found
        System.out.println("Minimum Sales: " + productSales.MinSales(QUARTERS));
    }
}