import java.util.Scanner;

public class Console {
    public String getInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Move with W, A, S, D keys...");
        try {
            return input.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input");
            return getInput();
        }
    }
}
