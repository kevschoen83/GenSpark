import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassHandler {

    private Console userInput;
    private FileHandler fileHandler;
    private Ticket currentTicket;
    private List<Integer> ticketIDList;

    public PassHandler() {
        instantiate(); //instantiate instances of other required classes

        userInput.gatherUserInput(); //Gathers user input from console

        currentTicket = new Ticket(userInput.getName(), userInput.getEmail(), userInput.getPhoneNumber(),
                userInput.getGender(), userInput.getAge(), userInput.getDate(),
                userInput.getDestination(), userInput.getDepartureTime());

        //pass input from user and calculations to Ticket constructor to create a valid ticket object

        //TODO Add ticket to ticketList, handle condition of duplicate key and generate new key until non duplicate is found
        //while(ticketIDList.contains(currentTicket.getBoardingPassID()))
            //currentTicket.generateNewID();
        ticketIDList.add(currentTicket.getBoardingPassID());
        //handle duplicate key

        fileHandler.createFile(currentTicket);

        fileHandler.createUserFile();

    }

    //Instantiate instances of Console, FileHandler and the ticketIDList
    private void instantiate() {
        userInput = new Console();
        fileHandler = new FileHandler();
        ticketIDList = fileHandler.getPreviousTicketNumbers();
    }
}
