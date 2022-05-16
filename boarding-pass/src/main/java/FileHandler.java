import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private File currentFile;

    //creates a non-user friendly file to be used for data storage and manipulation
    public boolean createFile(Ticket ticket) {

        String fileName = "Ticket" + 231 + ".txt";//TODO replace integer value with ticket.getID();
        currentFile = new File("src/main/resources/" + fileName);

        try {
            currentFile.createNewFile();
            writeData(ticket); //TODO write ticket data to file
        } catch (IOException e) {
            System.out.println("Cannot create file: FileHandler IOException");
            return false;
        }

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

            //generate new userFile
            String userFileName = "BoardingPass: " + currentFile.getName();
            File userFile = new File(userFileName);
            userFile.createNewFile();

            writeUserData(userFile, fileData); //TODO write data to userFile from original dataFile


        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file to generate userFile");
            return false;
        } catch (IOException e) {
            System.out.println("Cannot create userFile: FileHandler IOException");
            return false;
        }
        return true;


    }

    //writes ticket data to the file
    private void writeData(Ticket ticket) {
        //TODO write data
    }

    //writes data from current file to the user file
    private void writeUserData(File userFile, List fileData) {
        //TODO write data
    }

    //reads data from current file and returns a list of strings
    private List readData() {
        List<String> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(currentFile));
            //TODO read the data into data arraylist
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file to generate userFile");
        }

        return data;
    }
}
