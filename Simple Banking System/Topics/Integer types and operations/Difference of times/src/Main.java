import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();   // hours
        int num2 = scanner.nextInt();   // minutes
        int num3 = scanner.nextInt();   // seconds

        int num4 = scanner.nextInt();   // hours
        int num5 = scanner.nextInt();   // minutes
        int num6 = scanner.nextInt();   // seconds

        int hoursPassed = num4 - num1;
        int minutesPassed = num5 - num2;
        int secondsPassed = num6 - num3;

        final int totalSecondsPassed = (hoursPassed * 60 + minutesPassed) * 60 + secondsPassed;
        System.out.println(totalSecondsPassed);
    }
}
