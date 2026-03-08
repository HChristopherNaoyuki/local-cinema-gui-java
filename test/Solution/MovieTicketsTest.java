package Solution;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for MovieTickets business logic.
 * Contains unit tests for total price calculation and data validation.
 */
public class MovieTicketsTest
{
    private MovieTickets movieTickets;
    
    public MovieTicketsTest()
    {
        // Initialize the MovieTickets object before each test
        movieTickets = new MovieTickets();
    }

    /**
     * Test Case: CalculateTotalTicketPrice_CalculatedSuccessfully
     * Purpose: To supply the number of tickets and ticket price to the 
     * CalculateTotalTicketPrice method and verify the correct total price is returned.
     * Expected: 5 tickets at R120.00 should return R600.00
     */
    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully()
    {
        // Arrange - Set up test data
        int numberOfTickets = 5;
        double ticketPrice = 120.00;
        double expectedTotal = 600.00; // 5 * 120 = 600
        
        // Act - Call the method being tested
        double actualTotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        
        // Assert - Verify the result
        assertEquals("Total price should be 5 * 120 = 600.00", 
                     expectedTotal, actualTotal, 0.001);
    }
    
    /**
     * Test Case: CalculateTotalTicketPrice_ZeroTickets_ReturnsZero
     * Purpose: Test edge case where zero tickets are purchased.
     * Expected: 0 tickets at any price should return 0.00
     */
    @Test
    public void CalculateTotalTicketPrice_ZeroTickets_ReturnsZero()
    {
        // Arrange
        int numberOfTickets = 0;
        double ticketPrice = 120.00;
        double expectedTotal = 0.00;
        
        // Act
        double actualTotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        
        // Assert
        assertEquals("Zero tickets should result in zero total", 
                     expectedTotal, actualTotal, 0.001);
    }
    
    /**
     * Test Case: CalculateTotalTicketPrice_ZeroPrice_ReturnsZero
     * Purpose: Test edge case where ticket price is zero.
     * Expected: Any number of tickets at R0.00 should return 0.00
     */
    @Test
    public void CalculateTotalTicketPrice_ZeroPrice_ReturnsZero()
    {
        // Arrange
        int numberOfTickets = 5;
        double ticketPrice = 0.00;
        double expectedTotal = 0.00;
        
        // Act
        double actualTotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        
        // Assert
        assertEquals("Zero price should result in zero total", 
                     expectedTotal, actualTotal, 0.001);
    }
    
    /**
     * Test Case: CalculateTotalTicketPrice_LargeNumbers_ReturnsCorrectTotal
     * Purpose: Test calculation with larger numbers to ensure no overflow issues.
     * Expected: 1000 tickets at R150.50 should return R150,500.00
     */
    @Test
    public void CalculateTotalTicketPrice_LargeNumbers_ReturnsCorrectTotal()
    {
        // Arrange
        int numberOfTickets = 1000;
        double ticketPrice = 150.50;
        double expectedTotal = 150500.00; // 1000 * 150.50 = 150500
        
        // Act
        double actualTotal = movieTickets.CalculateTotalTicketPrice(numberOfTickets, ticketPrice);
        
        // Assert
        assertEquals("Large number calculation should be accurate", 
                     expectedTotal, actualTotal, 0.001);
    }
    
    /**
     * Test Case: ValidateData_ValidInput_ReturnsTrue
     * Purpose: Test that validation passes with valid input data.
     * Expected: Valid movie name, positive ticket count, positive price should return true
     */
    @Test
    public void ValidateData_ValidInput_ReturnsTrue()
    {
        // Arrange
        MovieTicketData validData = new MovieTicketData(
            "Oppenheimer", 
            "3", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(validData);
        
        // Assert
        assertTrue("Valid data should return true", isValid);
    }
    
    /**
     * Test Case: ValidateData_EmptyMovieName_ReturnsFalse
     * Purpose: Test that validation fails when movie name is empty.
     * Expected: Empty movie name should return false
     */
    @Test
    public void ValidateData_EmptyMovieName_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "", 
            "3", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Empty movie name should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_WhitespaceMovieName_ReturnsFalse
     * Purpose: Test that validation fails when movie name contains only whitespace.
     * Expected: Whitespace-only movie name should return false
     */
    @Test
    public void ValidateData_WhitespaceMovieName_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "   ", 
            "3", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Whitespace-only movie name should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_NullMovieName_ReturnsFalse
     * Purpose: Test that validation fails when movie name is null.
     * Expected: Null movie name should return false
     */
    @Test
    public void ValidateData_NullMovieName_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            null, 
            "3", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Null movie name should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_ZeroTickets_ReturnsFalse
     * Purpose: Test that validation fails when number of tickets is zero.
     * Expected: Zero tickets should return false
     */
    @Test
    public void ValidateData_ZeroTickets_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Napoleon", 
            "0", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Zero tickets should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_NegativeTickets_ReturnsFalse
     * Purpose: Test that validation fails when number of tickets is negative.
     * Expected: Negative tickets should return false
     */
    @Test
    public void ValidateData_NegativeTickets_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Napoleon", 
            "-5", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Negative tickets should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_NonNumericTickets_ReturnsFalse
     * Purpose: Test that validation fails when number of tickets is not numeric.
     * Expected: Non-numeric ticket count should return false
     */
    @Test
    public void ValidateData_NonNumericTickets_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Napoleon", 
            "five", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Non-numeric tickets should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_EmptyTicketsString_ReturnsFalse
     * Purpose: Test that validation fails when tickets string is empty.
     * Expected: Empty tickets string should return false
     */
    @Test
    public void ValidateData_EmptyTicketsString_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Napoleon", 
            "", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Empty tickets string should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_WhitespaceTicketsString_ReturnsFalse
     * Purpose: Test that validation fails when tickets string contains only whitespace.
     * Expected: Whitespace-only tickets string should return false
     */
    @Test
    public void ValidateData_WhitespaceTicketsString_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Napoleon", 
            "   ", 
            "150.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Whitespace-only tickets string should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_ZeroPrice_ReturnsFalse
     * Purpose: Test that validation fails when ticket price is zero.
     * Expected: Zero price should return false
     */
    @Test
    public void ValidateData_ZeroPrice_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Damsel", 
            "3", 
            "0.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Zero price should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_NegativePrice_ReturnsFalse
     * Purpose: Test that validation fails when ticket price is negative.
     * Expected: Negative price should return false
     */
    @Test
    public void ValidateData_NegativePrice_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Damsel", 
            "3", 
            "-50.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Negative price should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_NonNumericPrice_ReturnsFalse
     * Purpose: Test that validation fails when ticket price is not numeric.
     * Expected: Non-numeric price should return false
     */
    @Test
    public void ValidateData_NonNumericPrice_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Damsel", 
            "3", 
            "fifty"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Non-numeric price should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_EmptyPriceString_ReturnsFalse
     * Purpose: Test that validation fails when price string is empty.
     * Expected: Empty price string should return false
     */
    @Test
    public void ValidateData_EmptyPriceString_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Damsel", 
            "3", 
            ""
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Empty price string should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_WhitespacePriceString_ReturnsFalse
     * Purpose: Test that validation fails when price string contains only whitespace.
     * Expected: Whitespace-only price string should return false
     */
    @Test
    public void ValidateData_WhitespacePriceString_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "Damsel", 
            "3", 
            "   "
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("Whitespace-only price string should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_AllFieldsInvalid_ReturnsFalse
     * Purpose: Test validation when all fields are invalid simultaneously.
     * Expected: All invalid fields should return false
     */
    @Test
    public void ValidateData_AllFieldsInvalid_ReturnsFalse()
    {
        // Arrange
        MovieTicketData invalidData = new MovieTicketData(
            "", 
            "-5", 
            "-10.00"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(invalidData);
        
        // Assert
        assertFalse("All fields invalid should return false", isValid);
    }
    
    /**
     * Test Case: ValidateData_BoundaryValues_ReturnsTrue
     * Purpose: Test validation with minimum valid boundary values.
     * Expected: Minimum valid values (1 ticket, R0.01) should return true
     */
    @Test
    public void ValidateData_BoundaryValues_ReturnsTrue()
    {
        // Arrange
        MovieTicketData boundaryData = new MovieTicketData(
            "Napoleon", 
            "1", 
            "0.01"
        );
        
        // Act
        boolean isValid = movieTickets.ValidateData(boundaryData);
        
        // Assert
        assertTrue("Boundary valid values should return true", isValid);
    }
}