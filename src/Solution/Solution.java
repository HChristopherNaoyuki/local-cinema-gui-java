// Main application class for the Movie Ticket Processing System
// This class creates the GUI interface and handles user interactions
package Solution;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;

/**
 * Main application class for processing movie ticket sales.
 * Creates a GUI interface for selecting movies, entering ticket quantities and prices,
 * calculating totals with VAT, and saving reports to file.
 */
public class Solution extends JFrame
{
    // GUI Components
    private JComboBox<String> movieComboBox;
    private JTextField ticketCountField;
    private JTextField ticketPriceField;
    private JTextArea reportTextArea;
    
    // Menu components
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu toolsMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem processMenuItem;
    private JMenuItem clearMenuItem;
    
    // Constants
    private static final double VAT_RATE = 0.14; // 14% VAT rate
    private static final String[] MOVIES = {"Napoleon", "Oppenheimer", "Damsel"};
    private static final String LINE_SEPARATOR = "==================================================";
    
    // Business logic class
    private MovieTickets movieTickets;
    
    /**
     * Constructor initializes the GUI components and sets up the frame.
     */
    public Solution()
    {
        // Initialize the business logic class
        movieTickets = new MovieTickets();
        
        // Set up the main frame
        setTitle("Movie Ticket Sales System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(600, 500);
        setLocationRelativeTo(null); // Center the window
        
        // Create menu system
        createMenuBar();
        
        // Create main input panel
        JPanel inputPanel = createInputPanel();
        
        // Create report panel
        JPanel reportPanel = createReportPanel();
        
        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(reportPanel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    /**
     * Creates and configures the menu bar with File and Tools menus.
     */
    private void createMenuBar()
    {
        menuBar = new JMenuBar();
        
        // Create File menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt+F to access
        
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0); // Close the application
            }
        });
        fileMenu.add(exitMenuItem);
        
        // Create Tools menu
        toolsMenu = new JMenu("Tools");
        toolsMenu.setMnemonic(KeyEvent.VK_T); // Alt+T to access
        
        processMenuItem = new JMenuItem("Process");
        processMenuItem.setMnemonic(KeyEvent.VK_P);
        processMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                processTicketSale(); // Process the ticket sale
            }
        });
        toolsMenu.add(processMenuItem);
        
        clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.setMnemonic(KeyEvent.VK_C);
        clearMenuItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                clearForm(); // Clear all input fields
            }
        });
        toolsMenu.add(clearMenuItem);
        
        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        
        // Set the menu bar for the frame
        setJMenuBar(menuBar);
    }
    
    /**
     * Creates the input panel containing movie selection and ticket details.
     * @return JPanel containing all input components
     */
    private JPanel createInputPanel()
    {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Ticket Details"));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Movie Selection Label and ComboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Select Movie:"), gbc);
        
        gbc.gridx = 1;
        movieComboBox = new JComboBox<>(MOVIES);
        movieComboBox.setPreferredSize(new Dimension(200, 25));
        panel.add(movieComboBox, gbc);
        
        // Number of Tickets Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Number of Tickets:"), gbc);
        
        gbc.gridx = 1;
        ticketCountField = new JTextField(15);
        panel.add(ticketCountField, gbc);
        
        // Ticket Price Label and TextField
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Ticket Price (R):"), gbc);
        
        gbc.gridx = 1;
        ticketPriceField = new JTextField(15);
        panel.add(ticketPriceField, gbc);
        
        return panel;
    }
    
    /**
     * Creates the report panel with a read-only text area.
     * @return JPanel containing the report text area
     */
    private JPanel createReportPanel()
    {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Sales Report"));
        
        reportTextArea = new JTextArea(15, 50);
        reportTextArea.setEditable(false); // Read-only as per requirement
        reportTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        JScrollPane scrollPane = new JScrollPane(reportTextArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    /**
     * Processes the ticket sale: validates input, calculates totals,
     * displays the report, and saves to file.
     */
    private void processTicketSale()
    {
        try
        {
            // Get input values
            String selectedMovie = (String) movieComboBox.getSelectedItem();
            String ticketCountText = ticketCountField.getText().trim();
            String ticketPriceText = ticketPriceField.getText().trim();
            
            // Create MovieTicketData object for validation
            MovieTicketData ticketData = new MovieTicketData(
                selectedMovie, 
                ticketCountText, 
                ticketPriceText
            );
            
            // Validate the input data
            if (!movieTickets.ValidateData(ticketData))
            {
                JOptionPane.showMessageDialog(
                    this,
                    "Invalid input. Please check:\n" +
                    "- Movie name cannot be empty\n" +
                    "- Number of tickets must be > 0\n" +
                    "- Ticket price must be > 0",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            
            // Parse numeric values after validation
            int numberOfTickets = Integer.parseInt(ticketCountText);
            double ticketPrice = Double.parseDouble(ticketPriceText);
            
            // Calculate totals
            double subtotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
            double vatAmount = subtotal * VAT_RATE;
            double totalWithVAT = subtotal + vatAmount;
            
            // Generate and display report
            String report = generateReport(
                selectedMovie, 
                numberOfTickets, 
                ticketPrice, 
                subtotal, 
                vatAmount, 
                totalWithVAT
            );
            reportTextArea.setText(report);
            
            // Save report to file
            saveReportToFile(report);
            
            JOptionPane.showMessageDialog(
                this,
                "Ticket sale processed successfully!\nReport saved to report.txt",
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(
                this,
                "Please enter valid numeric values for tickets and price.",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(
                this,
                "An error occurred: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    /**
     * Generates a formatted sales report.
     * Java 8 compatible version (no String.repeat()).
     * @param movie Selected movie name
     * @param ticketCount Number of tickets
     * @param ticketPrice Price per ticket
     * @param subtotal Subtotal before VAT
     * @param vatAmount VAT amount calculated
     * @param total Total including VAT
     * @return Formatted report string
     */
    private String generateReport(
        String movie, 
        int ticketCount, 
        double ticketPrice, 
        double subtotal, 
        double vatAmount, 
        double total)
    {
        StringBuilder report = new StringBuilder();
        
        // Using string concatenation for Java 8 compatibility instead of String.repeat()
        report.append("==================================================\n");
        report.append("           MOVIE TICKET SALES REPORT\n");
        report.append("==================================================\n\n");
        
        report.append("Movie Selected: ").append(movie).append("\n");
        report.append("------------------------------\n");
        report.append(String.format("Number of Tickets: %d\n", ticketCount));
        report.append(String.format("Ticket Price: R%.2f\n", ticketPrice));
        report.append(String.format("Subtotal: R%.2f\n", subtotal));
        report.append(String.format("VAT (14%%): R%.2f\n", vatAmount));
        report.append("------------------------------\n");
        report.append(String.format("TOTAL AMOUNT: R%.2f\n", total));
        report.append("==================================================\n");
        report.append("Report Generated: ").append(new Date()).append("\n");
        report.append("==================================================");
        
        return report.toString();
    }
    
    /**
     * Saves the report content to a text file.
     * @param report The report content to save
     */
    private void saveReportToFile(String report)
    {
        BufferedWriter writer = null;
        
        try
        {
            // Use FileWriter in append mode (true as second parameter)
            writer = new BufferedWriter(new FileWriter("report.txt", true));
            writer.write(report);
            writer.newLine();
            writer.write("==================================================");
            writer.newLine();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(
                this,
                "Error saving report to file: " + e.getMessage(),
                "File Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
        finally
        {
            // Ensure resources are closed properly (Java 8 style)
            if (writer != null)
            {
                try
                {
                    writer.close();
                }
                catch (IOException e)
                {
                    // Log error but don't show to user
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Clears all input fields and the report area.
     */
    private void clearForm()
    {
        movieComboBox.setSelectedIndex(0); // Select first movie
        ticketCountField.setText("");
        ticketPriceField.setText("");
        reportTextArea.setText("");
    }
    
    /**
     * Main method to launch the application.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args)
    {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new Solution();
            }
        });
    }
}