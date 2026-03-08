// Business logic class for movie ticket processing
package Solution;

/**
 * Implementation of IMovieTickets interface.
 * Contains business logic for calculating totals and validating input data.
 */
public class MovieTickets implements IMovieTickets
{
    /**
     * Calculates the total ticket price (subtotal before VAT).
     * @param numberOfTickets The number of tickets purchased
     * @param ticketPrice The price per ticket
     * @return The calculated subtotal
     */
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice)
    {
        // Basic multiplication of quantity and unit price
        return numberOfTickets * ticketPrice;
    }
    
    /**
     * Validates all input data according to business rules:
     * - Movie name cannot be null or empty
     * - Number of tickets must be a positive integer > 0
     * - Ticket price must be a positive number > 0
     * @param movieTicketData The data object containing input values
     * @return true if all data is valid, false otherwise
     */
    @Override
    public boolean ValidateData(MovieTicketData movieTicketData)
    {
        // Check if movie name is valid (not null or empty)
        if (movieTicketData.getMovieName() == null || 
            movieTicketData.getMovieName().trim().isEmpty())
        {
            return false;
        }
        
        // Validate number of tickets
        try
        {
            int numberOfTickets = Integer.parseInt(movieTicketData.getNumberOfTickets());
            if (numberOfTickets <= 0)
            {
                return false; // Must be greater than 0
            }
        }
        catch (NumberFormatException e)
        {
            return false; // Not a valid integer
        }
        
        // Validate ticket price
        try
        {
            double ticketPrice = Double.parseDouble(movieTicketData.getTicketPrice());
            if (ticketPrice <= 0.0)
            {
                return false; // Must be greater than 0
            }
        }
        catch (NumberFormatException e)
        {
            return false; // Not a valid number
        }
        
        // All validations passed
        return true;
    }
}