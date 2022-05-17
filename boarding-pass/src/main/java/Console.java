import java.util.Scanner;

public class Console {

    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private int age;
    private String date;
    private String destination;
    private String departureTime;

    public void gatherUserInput() {

        System.out.print("Enter your full name:  ");
        name = getInput();
        System.out.print("Enter your email address:  ");
        email = getInput();
        System.out.print("Enter your phone number:  ");
        phoneNumber = getInput();
        System.out.print("Enter your gender:  ");
        gender = getInput();
        System.out.print("Enter your age:  ");
        try {
            age = Integer.parseInt(getInput());
        }
        catch(Exception e) {
            age = -1;
        }

        System.out.print("Enter the date of your flight:  ");
        date = getInput();
        System.out.print("Enter your destination:  ");
        destination = getInput();
        System.out.print("Enter your departure time:  ");
        departureTime = getInput();
        System.out.println();


    }

    public static void displayTicket(Ticket ticket) {
        System.out.println("Name: " + ticket.getName());
        System.out.println("Email: " + ticket.getEmail());
        System.out.println("Phone Number: " + ticket.getPhone());
        System.out.println("Gender: " + ticket.getGender());
        System.out.println("Age: " + ticket.getAge());
        System.out.println("Date: " + ticket.getDate());
        System.out.println("Destination: " + ticket.getDestination());
        System.out.println("Departure Time: " + ticket.getDepartureTime());
    }

    private String getInput() {
        Scanner input = new Scanner(System.in);
        try {
            return input.nextLine();
        }catch (Exception e) {
            System.out.println("Invalid input");
            return getInput();
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }
}
