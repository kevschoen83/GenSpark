import java.util.Scanner;

public class Console {

    private String name;
    private String email;
    private long phoneNumber;
    private String gender;
    private int age;
    private long date;
    private String destination;
    private int departureTime;

    public void gatherUserInput() {

        System.out.print("Enter your full name:  ");
        name = getInput();

        System.out.print("Enter your Email:  ");
        email = promptEmail();

        System.out.print("Enter your phone number (digits only):  ");
        phoneNumber = promptLong("Phone Number");

        System.out.print("Enter your gender:  ");
        gender = getInput();

        System.out.print("Enter your age:  ");
        age = promptInt("Age");

        System.out.print("Enter the date of your flight (digits only):  ");
        date = promptLong("Date");

        System.out.print("Enter your destination:  ");
        destination = getInput();

        System.out.print("Enter your departure time (military time):  ");
        departureTime = promptInt("Departure Time");

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

    private String promptEmail() {
        String input = getInput();
        if(!input.contains("@")) {
            System.out.println("Invalid Email, please enter a valid email format (yourEmail@domain.com)");
            input = promptEmail();
        }
        return input;
    }

    private int promptInt(String fieldInfo) {
        try {
            return Integer.parseInt(getInput());
        }
        catch(NumberFormatException e) {
            System.out.println("Invalid " + fieldInfo + ", please enter a valid integer format");
            if(fieldInfo.toLowerCase().startsWith("departure"))
                System.out.println(fieldInfo + " format example: 1730  (5:30pm)");
            return promptInt(fieldInfo);
        }
    }

    private long promptLong(String fieldInfo) {
        try {
            return Long.valueOf(getInput());
        }
        catch(NumberFormatException e) {
            System.out.println("Invalid " + fieldInfo + ", please enter a valid long format");
            if(fieldInfo.toLowerCase().startsWith("date"))
                System.out.println(fieldInfo + " format example: 4022022  (April 2, 2022)");
            return promptLong(fieldInfo);
        }
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public long getDate() {
        return date;
    }

    public String getDestination() {
        return destination;
    }

    public int getDepartureTime() {
        return departureTime;
    }
}
