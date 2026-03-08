// Data container class for movie ticket input validation
package Solution;

/**
 * Data class that holds the raw input values for validation.
 * Used to pass multiple related parameters to validation methods.
 */
public class MovieTicketData
{
    private String movieName;
    private String numberOfTickets;
    private String ticketPrice;
    
    /**
     * Constructor to initialize the movie ticket data.
     * @param movieName The selected movie name
     * @param numberOfTickets The number of tickets as string input
     * @param ticketPrice The ticket price as string input
     */
    public MovieTicketData(String movieName, String numberOfTickets, String ticketPrice)
    {
        this.movieName = movieName;
        this.numberOfTickets = numberOfTickets;
        this.ticketPrice = ticketPrice;
    }
    
    // Getters and Setters
    public String getMovieName()
    {
        return movieName;
    }
    
    public void setMovieName(String movieName)
    {
        this.movieName = movieName;
    }
    
    public String getNumberOfTickets()
    {
        return numberOfTickets;
    }
    
    public void setNumberOfTickets(String numberOfTickets)
    {
        this.numberOfTickets = numberOfTickets;
    }
    
    public String getTicketPrice()
    {
        return ticketPrice;
    }
    
    public void setTicketPrice(String ticketPrice)
    {
        this.ticketPrice = ticketPrice;
    }
}