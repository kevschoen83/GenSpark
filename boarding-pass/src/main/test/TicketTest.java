import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    void generatePrice() {
        Ticket ticket = new Ticket(
                "Jackson",
                "jks@gmail.com",
                7333452375L,
                "Male",
                27,
                5192022L,
                "New York",
                1700
        );

        System.out.println("Price: " + ticket.getPrice());
    }

    @Test
    void setBoardingPassID() {
        Ticket ticket = new Ticket(
                "Jackson",
                "jks@gmail.com",
                7333452375L,
                "Male",
                27,
                5192022L,
                "New York",
                1700
        );

        int oldID = ticket.getBoardingPassID();
        ticket.setBoardingPassID();
        System.out.println("Old ID: " + oldID);
        System.out.println("New ID: " + ticket.getBoardingPassID());
        Assert.assertNotEquals(oldID, ticket.getBoardingPassID());
    }
}