import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        boolean num1True = num1 > 0 && num2 <= 0 && num3 <= 0;
        boolean num2True = num2 > 0 && num1 <= 0 && num3 <= 0;
        boolean num3True = num3 > 0 && num1 <= 0 && num2 <= 0;

        if (num1True || num2True || num3True) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}