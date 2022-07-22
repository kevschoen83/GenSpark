import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equals("0")) {
            input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            } else {
                try {
                    int num = Integer.parseInt(input);
                    System.out.println(num * 10);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid user input: " + input);
                }
            }
        }

    }
}
