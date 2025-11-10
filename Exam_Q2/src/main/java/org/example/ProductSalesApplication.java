package org.example;
import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

// Main GUI class for the Product Sales Application
public class ProductSalesApplication extends JFrame {

    // Text area to display product data
    private JTextArea textArea;

    // Label to display number of years processed
    private JLabel lblYearsProcessed;

    // ProductSales object to handle sales data
    private ProductSales sales;

    // Constant defining the sales limit
    private final int SALES_LIMIT = 500;

    // Constructor to set up the GUI
    public ProductSalesApplication() {

        // Initialize the ProductSales object
        sales = new ProductSales();

        // Frame settings
        setTitle("Product Sales Application");                // Window title
        setLayout(new BorderLayout(10, 10));                 // Layout with gaps
        setSize(380, 330);                                   // Window size
        setLocationRelativeTo(null);                          // Center window on screen
        getContentPane().setBackground(new Color(100, 100, 150)); // Background color
        setDefaultCloseOperation(EXIT_ON_CLOSE);            // Exit app when closed
        setVisible(true);                                   // Make the window visible

        // ------------------- BUTTON PANEL -------------------
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 1, 7, 5));     // Grid layout: 2 rows, 1 column, gaps
        JButton buttonLoad = new JButton("Load Product Data"); // Button to load data
        JButton buttonSave = new JButton("Save Product Data"); // Button to save data
        buttonLoad.setFocusable(false);                     // Remove focus border for aesthetics
        buttonSave.setFocusable(false);
        topPanel.add(buttonLoad);                            // Add load button to panel
        topPanel.add(buttonSave);                            // Add save button to panel
        add(topPanel, BorderLayout.NORTH);                  // Add panel to top of frame

        // ------------------- TEXT AREA -------------------
        textArea = new JTextArea(8, 30);                    // Create text area with 8 rows, 30 cols
        textArea.setEditable(false);                        // Make it read-only
        textArea.setBorder(BorderFactory.createTitledBorder("Product Data")); // Add titled border
        add(new JScrollPane(textArea), BorderLayout.CENTER); // Add text area with scroll pane to center

        // ------------------- LABEL -------------------
        lblYearsProcessed = new JLabel("Years Processed: 0", SwingConstants.CENTER); // Centered label
        lblYearsProcessed.setFont(new Font("SansSerif", Font.BOLD, 14));            // Bold font
        add(lblYearsProcessed, BorderLayout.SOUTH);       // Add label to bottom of frame

        // ------------------- MENU BAR -------------------
        JMenuBar menuBar = new JMenuBar();                // Create menu bar
        JMenu fileMenu = new JMenu("File");              // File menu
        JMenu toolsMenu = new JMenu("Tools");            // Tools menu

        // Menu items
        JMenuItem exitItem = new JMenuItem("Exit");      // Exit option
        JMenuItem loadItem = new JMenuItem("Load Product Data"); // Load data option
        JMenuItem saveItem = new JMenuItem("Save Product Data"); // Save data option
        JMenuItem clearItem = new JMenuItem("Clear");   // Clear data option

        // Add items to menus
        fileMenu.add(exitItem);
        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);                             // Set menu bar on frame

        // ------------------- EVENT HANDLERS -------------------
        buttonLoad.addActionListener(e -> loadData());   // Load button action
        buttonSave.addActionListener(e -> saveData());   // Save button action
        loadItem.addActionListener(e -> loadData());     // Menu load action
        saveItem.addActionListener(e -> saveData());     // Menu save action
        clearItem.addActionListener(e -> clearData());   // Menu clear action
        exitItem.addActionListener(e -> System.exit(0)); // Menu exit action
    }

    // Method to load data from ProductSales object and display it
    private void loadData() {
        int total = sales.getTotalProductSales();        // Get total product sales
        double average = sales.getAverageSales();        // Get average sales
        int over = sales.getSalesOverLimit(SALES_LIMIT); // Count sales over limit
        int under = sales.getSalesUnderLimit(SALES_LIMIT); // Count sales under limit
        int years = sales.getProductsProcessed();        // Get number of years processed

        // Build report string
        String report = "Total Sales: " + total + "\n"
                + "Average Sales: " + (int) average + "\n"
                + "Sales over limit: " + over + "\n"
                + "Sales under limit: " + under + "\n";

        textArea.setText(report);                        // Display report in text area
        lblYearsProcessed.setText("Years Processed: " + years); // Update label
    }

    // Method to save displayed data to a file
    private void saveData() {
        try (FileWriter writer = new FileWriter("data.txt")) { // Auto-close FileWriter
            writer.write("DATA LOG\n**************************************\n");
            writer.write(textArea.getText());            // Write report
            writer.write("*******************************************\n");
            JOptionPane.showMessageDialog(this, "Data saved to data.txt successfully"); // Confirmation
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error occurred while saving file."); // Error handling
        }
    }

    // Method to clear text area and label
    private void clearData() {
        textArea.setText("");                             // Clear report
        lblYearsProcessed.setText("Years Processed: 0"); // Reset label
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductSalesApplication::new); // makes GUI runs on EDT
    }
}