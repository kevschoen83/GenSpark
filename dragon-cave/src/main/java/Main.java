import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DragonCave game = new DragonCave();
        game.CaveChoice();
    }

}

class DragonCave {
    Scanner scanner = new Scanner(System.in);
    // Constructor
    public DragonCave() {
        System.out.println("Welcome, brave warrior, to the Dragon Cave!  Tell us your name so that " +
                "stories may be told and songs sung about your adventures.");
        System.out.print("Input your name: ");
        try {
            String name = scanner.nextLine();
            System.out.println("Welcome " + name + "!  Lets begin...");
        } catch (Exception e) {
            System.out.println("Input Mismatch.");
        }
        System.out.println();
        System.out.println();
        System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the " +
                "dragon is friendly and will");
        System.out.println("share his treasure with you. The other dragon is greedy and will eat you on sight.");
        System.out.print("Which cave will you go into? (1 or 2) ");
    }

    void CaveChoice() {
        try {
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println();
                System.out.println("You approach the cave...");
                System.out.println("It is dark and spooky...");
                System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
                System.out.println("Gobbles you down in one bite!");
            } else if (choice == 2) {
                System.out.println();
                System.out.println("You approach the cave...");
                System.out.println("As you near the entrance, you become aware of a unique smell and sound " +
                        "coming from the dark cave...");
                System.out.println("The longer you listen, the more you realize that the sound seems to be music..." +
                        "and the smell is that of tender meat...what is going on?");
                System.out.println();
                System.out.println("Upon peaking around the corner, you realize that a group of three green dragons are " +
                        "having dinner and a karaoke party!");
                System.out.println("The dragons spot you in the entrance and immediately invite you in to share in their " +
                        "food, drink, fun, and treasure!  Congratulations!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input Mismatch.");
        }
    }
}
