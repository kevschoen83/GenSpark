import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main boardingPass = new Main();
        boardingPass.gatherUserInput();
    }

    void gatherUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your full name:  ");
        String name = input.nextLine();
        System.out.print("Enter your email address:  ");
        String email = input.nextLine();
        System.out.print("Enter your phone number:  ");
        String phoneNumber = input.nextLine();
        System.out.print("Enter your gender:  ");
        String gender = input.nextLine();
        System.out.print("Enter your age:  ");
        int age = Integer.parseInt(input.nextLine());
        System.out.print("Enter the date of your flight:  ");
        String date = input.nextLine();
        System.out.print("Enter your destination:  ");
        String destination = input.nextLine();
        System.out.print("Enter your departure time:  ");
        String departureTime = input.nextLine();
        System.out.println();

        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Gender: " + gender);
        System.out.println("Age: " + age);
        System.out.println("Date: " + date);
        System.out.println("Destination: " + destination);
        System.out.println("Departure Time: " + departureTime);
    }
}
