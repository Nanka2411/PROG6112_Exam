package org.example;

// Interface defining the operations for a Product Sales class
public interface IProductSales {

    /**
     * Calculates and returns the total sales of all products across all years.
     * @return total sum of all product sales
     */
    int getTotalProductSales();

    /**
     * Counts the number of sales that exceed a specified limit.
     * @param limit the threshold value to compare sales against
     * @return the number of sales greater than the limit
     */
    int getSalesOverLimit(int limit);

    /**
     * Counts the number of sales that are below a specified limit.
     * @param limit the threshold value to compare sales against
     * @return the number of sales less than the limit
     */
    int getSalesUnderLimit(int limit);

    /**
     * Returns the number of "years" or rows of sales data processed.
     * Essentially, it tells how many sets of sales data are available.
     * @return number of years (or sets) of sales data
     */
    int getProductsProcessed();

    /**
     * Calculates the average sale value across all products and years.
     * This is done by dividing total sales by the total number of sales entries.
     * @return average sale amount as a double
     */
    double getAverageSales();
}