import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        String numStr = "";

        while (num > 0) {
            int temp = num % 10;
            numStr += temp;
            num /= 10;
        }

        int reverseNum = Integer.parseInt(numStr);

        if (num == reverseNum) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}