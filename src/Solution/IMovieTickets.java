// Interface defining the contract for movie ticket processing
package Solution;

/**
 * Interface for movie ticket processing operations.
 * Defines methods for calculating totals and validating data.
 */
public interface IMovieTickets
{
    /**
     * Calculates the total ticket price based on quantity and unit price.
     * @param numberOfTickets The number of tickets purchased
     * @param ticketPrice The price per ticket
     * @return The subtotal before VAT
     */
    double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice);
    
    /**
     * Validates the movie ticket data according to business rules.
     * @param movieTicketData The data object containing input values
     * @return true if data is valid, false otherwise
     */
    boolean ValidateData(MovieTicketData movieTicketData);
}