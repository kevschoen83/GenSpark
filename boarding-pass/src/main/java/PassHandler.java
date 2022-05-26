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

        //pass input from user to Ticket constructor to create a Ticket object
        currentTicket = new Ticket(userInput.getName(), userInput.getEmail(), userInput.getPhoneNumber(),
                userInput.getGender(), userInput.getAge(), userInput.getDate(),
                userInput.getDestination(), userInput.getDepartureTime());

        //handle condition of duplicate key (BoardingPassID) and generate new key until non duplicate is found
        while(ticketIDList.contains(currentTicket.getBoardingPassID()))
            currentTicket.setBoardingPassID(); //handle duplicate key

        ticketIDList.add(currentTicket.getBoardingPassID());


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
