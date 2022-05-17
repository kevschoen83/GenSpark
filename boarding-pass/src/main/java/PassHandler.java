import java.util.HashMap;
import java.util.Map;

public class PassHandler {

    private Console userInput;
    private FileHandler fileHandler;
    private Ticket currentTicket;
    private Map<Integer, Ticket> ticketList;

    public PassHandler() {
        instantiate(); //instantiate instances of other required classes

        userInput.gatherUserInput(); //Gathers user input from console
        //TODO get input from Console instance

        //TODO Perform calculations to determine ETA, Price and randomly generate a unique Boarding Pass ID
        //generateData(userInput);

        /*currentTicket = new Ticket(userInput.getName(), userInput.getEmail(), userInput.getPhoneNumber(),
                userInput.getGender(), userInput.getAge(), userInput.getDate(),
                userInput.getDestination(), userInput.getDepartureTime());*/
        //pass input from user and calculations to Ticket constructor to create a valid ticket object

        //TODO Add ticket to ticketList, handle condition of duplicate key and generate new key until non duplicate is found
        //ticketList.put(currentTicket.ID, currentTicket);
        //handle duplicate key

        //TODO Store ticket info into a file (non user friendly)
        //fileHandler.createFile(currentTicket)

        //TODO Generate user friendly file from current file
        //fileHandler.createUserFile(currentTicket)

    }

    //Instantiate instances of Console, FileHandler and the ticketList hashmap
    private void instantiate() {
        userInput = new Console();
        fileHandler = new FileHandler();
        ticketList = new HashMap<>();
    }
}
