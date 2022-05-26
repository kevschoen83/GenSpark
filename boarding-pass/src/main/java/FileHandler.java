import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileHandler {

    private File currentFile;
    private String lastFileName;

    //creates a non-user friendly file to be used for data storage and manipulation
    public boolean createFile(Ticket ticket) {

        //create new file of name Ticket[boardingPassID].txt
        lastFileName = "Ticket" + ticket.getBoardingPassID() + ".txt";
        currentFile = new File("src/main/resources/" + lastFileName);

        //try to create the ticket file, return false if exception thrown
        try {
            currentFile.createNewFile();
            writeData(ticket);
        } catch (IOException e) {
            System.out.println("Cannot create file: FileHandler IOException");
            return false;
        }

        //return true on success
        return true;
    }

    //creates a user friendly (easily readable) file from original file
    public boolean createUserFile() {
        if(currentFile == null) {
            System.out.println("No file to generate userFile from.");
            return false;
        }

        try {
            List<String> fileData = readData(); //get data from the current file

            for(String x : fileData)
                System.out.println(x);

            //generate new userFile
            String userFileName = "BoardingPass-" + lastFileName;
            File userFile = new File("src/main/resources/" + userFileName);
            userFile.createNewFile();

            writeUserData(userFile, fileData);


        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file to generate userFile");
            return false;
        } catch (IOException e) {
            System.out.println("Cannot create userFile: FileHandler IOException");
            return false;
        }
        //return false if exception thrown, otherwise return true
        return true;


    }

    //returns a list of all ticket IDs from files within src/main/resources/ folder
    //creates the resources folder if it does not exist
    public List<Integer> getPreviousTicketNumbers() {
        List<Integer> ticketIDs = new ArrayList<>();
        File folder = new File("src/main/resources/");
        if (!folder.exists()){
            folder.mkdir();
        }
        File[] listOfFiles = folder.listFiles();

        //add the ID of each ticket file to ticketIDs array
        if(listOfFiles != null) {
            for(File file : listOfFiles) {
                if(file.isFile() && file.getName().startsWith("Ticket")) {
                    ticketIDs.add(getIDFromFile(file));
                }
            }
        }


        return ticketIDs;
    }

    //returns the first line from a file, expected to be the Boarding Pass ID parsed as an int
    private int getIDFromFile(File file) {
        int id = -1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            id = Integer.parseInt(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found, unable to retrieve ID: FileHandler FileNotFoundException");
        } catch (IOException e) {
            System.out.println("Can't parse Boarding Pass ID to Integer: FileHandler IOException");
        }
        return id;
    }

    //writes ticket data to the file
    private void writeData(Ticket ticket) {
        try{
            FileWriter fw = new FileWriter(currentFile);
            BufferedWriter br = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(br);

            pw.println(ticket.getBoardingPassID());
            pw.println(ticket.getDate());
            pw.println(ticket.getOrigin());
            pw.println(ticket.getDestination());
            pw.println(ticket.getEta());
            pw.println(ticket.getDepartureTime());
            pw.println(ticket.getName());
            pw.println(ticket.getEmail());
            pw.println(ticket.getPhone());
            pw.println(ticket.getGender());
            pw.println(ticket.getAge());
            pw.println(ticket.getPrice());

            pw.close();
        }
        catch (IOException e) {
            System.out.println("Cannot write data to file: FileHandler IOException");
        }

    }

    //writes data from current file to the user file
    private void writeUserData(File userFile, List fileData) {
        try{
            FileWriter fw = new FileWriter(userFile);
            BufferedWriter br = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(br);

            pw.println("Boarding Pass Number: " + fileData.get(0));
            pw.println("Date: " + fileData.get(1));
            pw.println("Origin: " + fileData.get(2));
            pw.println("Destination: " + fileData.get(3));
            pw.println("ETA: " + fileData.get(4));
            pw.println("Departure Time: " + fileData.get(5));
            pw.println("Passenger Name: " + fileData.get(6));
            pw.println("Passenger Email: " + fileData.get(7));
            pw.println("Passenger Phone: " + fileData.get(8));
            pw.println("Passenger Gender: " + fileData.get(9));
            pw.println("Passenger Age: " + fileData.get(10));
            pw.println("Total Price: " + fileData.get(11));

            pw.close();
        }
        catch (IOException e) {
            System.out.println("Cannot write data to file: FileHandler IOException");
        }
    }

    //reads data from current file and returns a list of strings
    private List readData() {
        List<String> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(currentFile));
            data = br.lines()
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file to generate userFile");
        }

        return data;
    }
}
