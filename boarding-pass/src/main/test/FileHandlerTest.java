import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.List;

class FileHandlerTest {

    @Test
    void createFile() {
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

        FileHandler fh = new FileHandler();

        Assert.assertTrue(fh.createFile(ticket));
    }

    @Test
    void createUserFile() {
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

        FileHandler fh = new FileHandler();

        fh.createFile(ticket);
        Assert.assertTrue(fh.createUserFile());
    }

    @Test
    void getPreviousTicketNumbers() {
        FileHandler fh = new FileHandler();
        List<Integer> ticketIDs = fh.getPreviousTicketNumbers();
        for(int x : ticketIDs) {
            System.out.println("Ticket: " + x);
        }
    }
}