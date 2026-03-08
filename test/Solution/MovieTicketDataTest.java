package Solution;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for MovieTicketData data container.
 * Ensures proper storage and retrieval of data through constructors and getter/setter methods.
 */
public class MovieTicketDataTest
{
    private MovieTicketData ticketData;
    
    public MovieTicketDataTest()
    {
        // Create a test object with initial values
        ticketData = new MovieTicketData("Napoleon", "5", "120.50");
    }

    /**
     * Test Case: Constructor_ValidInput_SetsAllFields
     * Purpose: Test that the constructor properly initializes all fields with provided values.
     * Expected: All fields should contain the values passed to the constructor.
     */
    @Test
    public void Constructor_ValidInput_SetsAllFields()
    {
        // Arrange
        String expectedMovie = "Oppenheimer";
        String expectedTickets = "3";
        String expectedPrice = "150.75";
        
        // Act
        MovieTicketData newData = new MovieTicketData(expectedMovie, expectedTickets, expectedPrice);
        
        // Assert
        assertEquals("Movie name should match constructor parameter", 
                     expectedMovie, newData.getMovieName());
        assertEquals("Number of tickets should match constructor parameter", 
                     expectedTickets, newData.getNumberOfTickets());
        assertEquals("Ticket price should match constructor parameter", 
                     expectedPrice, newData.getTicketPrice());
    }
    
    /**
     * Test Case: Constructor_NullValues_AllowsNull
     * Purpose: Test that the constructor accepts null values (validation handled separately).
     * Expected: Constructor should allow null values without throwing exceptions.
     */
    @Test
    public void Constructor_NullValues_AllowsNull()
    {
        // Act
        MovieTicketData nullData = new MovieTicketData(null, null, null);
        
        // Assert
        assertNull("Movie name should be null", nullData.getMovieName());
        assertNull("Number of tickets should be null", nullData.getNumberOfTickets());
        assertNull("Ticket price should be null", nullData.getTicketPrice());
    }
    
    /**
     * Test Case: Constructor_EmptyStrings_AllowsEmpty
     * Purpose: Test that the constructor accepts empty strings (validation handled separately).
     * Expected: Constructor should allow empty strings without throwing exceptions.
     */
    @Test
    public void Constructor_EmptyStrings_AllowsEmpty()
    {
        // Act
        MovieTicketData emptyData = new MovieTicketData("", "", "");
        
        // Assert
        assertEquals("Movie name should be empty string", "", emptyData.getMovieName());
        assertEquals("Number of tickets should be empty string", "", emptyData.getNumberOfTickets());
        assertEquals("Ticket price should be empty string", "", emptyData.getTicketPrice());
    }
    
    /**
     * Test Case: GetMovieName_AfterConstruction_ReturnsCorrectValue
     * Purpose: Test that getMovieName returns the value set by constructor.
     * Expected: Should return "Napoleon" from the test fixture.
     */
    @Test
    public void GetMovieName_AfterConstruction_ReturnsCorrectValue()
    {
        // Assert
        assertEquals("Movie name should be 'Napoleon'", 
                     "Napoleon", ticketData.getMovieName());
    }
    
    /**
     * Test Case: SetMovieName_ValidValue_GetsSameValue
     * Purpose: Test that setMovieName stores a value and getMovieName retrieves it correctly.
     * Expected: After setting "Oppenheimer", getMovieName should return "Oppenheimer".
     */
    @Test
    public void SetMovieName_ValidValue_GetsSameValue()
    {
        // Arrange
        String newMovieName = "Oppenheimer";
        
        // Act
        ticketData.setMovieName(newMovieName);
        String retrievedName = ticketData.getMovieName();
        
        // Assert
        assertEquals("Movie name should match the set value", 
                     newMovieName, retrievedName);
    }
    
    /**
     * Test Case: SetMovieName_NullValue_GetsNull
     * Purpose: Test that setMovieName accepts null values.
     * Expected: After setting null, getMovieName should return null.
     */
    @Test
    public void SetMovieName_NullValue_GetsNull()
    {
        // Act
        ticketData.setMovieName(null);
        String retrievedName = ticketData.getMovieName();
        
        // Assert
        assertNull("Movie name should be null", retrievedName);
    }
    
    /**
     * Test Case: SetMovieName_EmptyString_GetsEmptyString
     * Purpose: Test that setMovieName accepts empty strings.
     * Expected: After setting empty string, getMovieName should return empty string.
     */
    @Test
    public void SetMovieName_EmptyString_GetsEmptyString()
    {
        // Act
        ticketData.setMovieName("");
        String retrievedName = ticketData.getMovieName();
        
        // Assert
        assertEquals("Movie name should be empty string", "", retrievedName);
    }
    
    /**
     * Test Case: GetNumberOfTickets_AfterConstruction_ReturnsCorrectValue
     * Purpose: Test that getNumberOfTickets returns the value set by constructor.
     * Expected: Should return "5" from the test fixture.
     */
    @Test
    public void GetNumberOfTickets_AfterConstruction_ReturnsCorrectValue()
    {
        // Assert
        assertEquals("Number of tickets should be '5'", 
                     "5", ticketData.getNumberOfTickets());
    }
    
    /**
     * Test Case: SetNumberOfTickets_ValidValue_GetsSameValue
     * Purpose: Test that setNumberOfTickets stores a value and getNumberOfTickets retrieves it.
     * Expected: After setting "10", getNumberOfTickets should return "10".
     */
    @Test
    public void SetNumberOfTickets_ValidValue_GetsSameValue()
    {
        // Arrange
        String newTicketCount = "10";
        
        // Act
        ticketData.setNumberOfTickets(newTicketCount);
        String retrievedCount = ticketData.getNumberOfTickets();
        
        // Assert
        assertEquals("Ticket count should match the set value", 
                     newTicketCount, retrievedCount);
    }
    
    /**
     * Test Case: SetNumberOfTickets_NullValue_GetsNull
     * Purpose: Test that setNumberOfTickets accepts null values.
     * Expected: After setting null, getNumberOfTickets should return null.
     */
    @Test
    public void SetNumberOfTickets_NullValue_GetsNull()
    {
        // Act
        ticketData.setNumberOfTickets(null);
        String retrievedCount = ticketData.getNumberOfTickets();
        
        // Assert
        assertNull("Number of tickets should be null", retrievedCount);
    }
    
    /**
     * Test Case: SetNumberOfTickets_EmptyString_GetsEmptyString
     * Purpose: Test that setNumberOfTickets accepts empty strings.
     * Expected: After setting empty string, getNumberOfTickets should return empty string.
     */
    @Test
    public void SetNumberOfTickets_EmptyString_GetsEmptyString()
    {
        // Act
        ticketData.setNumberOfTickets("");
        String retrievedCount = ticketData.getNumberOfTickets();
        
        // Assert
        assertEquals("Number of tickets should be empty string", "", retrievedCount);
    }
    
    /**
     * Test Case: GetTicketPrice_AfterConstruction_ReturnsCorrectValue
     * Purpose: Test that getTicketPrice returns the value set by constructor.
     * Expected: Should return "120.50" from the test fixture.
     */
    @Test
    public void GetTicketPrice_AfterConstruction_ReturnsCorrectValue()
    {
        // Assert
        assertEquals("Ticket price should be '120.50'", 
                     "120.50", ticketData.getTicketPrice());
    }
    
    /**
     * Test Case: SetTicketPrice_ValidValue_GetsSameValue
     * Purpose: Test that setTicketPrice stores a value and getTicketPrice retrieves it.
     * Expected: After setting "150.75", getTicketPrice should return "150.75".
     */
    @Test
    public void SetTicketPrice_ValidValue_GetsSameValue()
    {
        // Arrange
        String newPrice = "150.75";
        
        // Act
        ticketData.setTicketPrice(newPrice);
        String retrievedPrice = ticketData.getTicketPrice();
        
        // Assert
        assertEquals("Ticket price should match the set value", 
                     newPrice, retrievedPrice);
    }
    
    /**
     * Test Case: SetTicketPrice_NullValue_GetsNull
     * Purpose: Test that setTicketPrice accepts null values.
     * Expected: After setting null, getTicketPrice should return null.
     */
    @Test
    public void SetTicketPrice_NullValue_GetsNull()
    {
        // Act
        ticketData.setTicketPrice(null);
        String retrievedPrice = ticketData.getTicketPrice();
        
        // Assert
        assertNull("Ticket price should be null", retrievedPrice);
    }
    
    /**
     * Test Case: SetTicketPrice_EmptyString_GetsEmptyString
     * Purpose: Test that setTicketPrice accepts empty strings.
     * Expected: After setting empty string, getTicketPrice should return empty string.
     */
    @Test
    public void SetTicketPrice_EmptyString_GetsEmptyString()
    {
        // Act
        ticketData.setTicketPrice("");
        String retrievedPrice = ticketData.getTicketPrice();
        
        // Assert
        assertEquals("Ticket price should be empty string", "", retrievedPrice);
    }
    
    /**
     * Test Case: SetAllProperties_ChainedOperations_AllUpdated
     * Purpose: Test that all properties can be updated in sequence.
     * Expected: After updating all fields, all getters should return the new values.
     */
    @Test
    public void SetAllProperties_ChainedOperations_AllUpdated()
    {
        // Arrange
        String newMovie = "Damsel";
        String newTickets = "8";
        String newPrice = "135.25";
        
        // Act
        ticketData.setMovieName(newMovie);
        ticketData.setNumberOfTickets(newTickets);
        ticketData.setTicketPrice(newPrice);
        
        // Assert
        assertEquals("Movie name should be updated", newMovie, ticketData.getMovieName());
        assertEquals("Ticket count should be updated", newTickets, ticketData.getNumberOfTickets());
        assertEquals("Ticket price should be updated", newPrice, ticketData.getTicketPrice());
    }
    
    /**
     * Test Case: ObjectIndependence_MultipleInstances_DoNotInterfere
     * Purpose: Test that changes to one MovieTicketData instance don't affect another.
     * Expected: Each instance should maintain its own state independently.
     */
    @Test
    public void ObjectIndependence_MultipleInstances_DoNotInterfere()
    {
        // Arrange
        MovieTicketData data1 = new MovieTicketData("Napoleon", "2", "100.00");
        MovieTicketData data2 = new MovieTicketData("Oppenheimer", "4", "150.00");
        
        // Act
        data1.setMovieName("Damsel");
        
        // Assert
        assertEquals("data1 movie should be changed", "Damsel", data1.getMovieName());
        assertEquals("data2 movie should remain unchanged", 
                     "Oppenheimer", data2.getMovieName());
        assertEquals("data2 tickets should remain unchanged", "4", data2.getNumberOfTickets());
        assertEquals("data2 price should remain unchanged", "150.00", data2.getTicketPrice());
    }
}