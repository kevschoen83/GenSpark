import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfUnits = scanner.nextInt();

        if (numOfUnits < 1) {
            System.out.println("no army");
        } else if (numOfUnits >= 1 && numOfUnits <= 19) {
            System.out.println("pack");
        } else if (numOfUnits >= 20 && numOfUnits <= 249) {
            System.out.println("throng");
        } else if (numOfUnits >= 250 && numOfUnits <= 999) {
            System.out.println("zounds");
        } else if (numOfUnits >= 1000) {
            System.out.println("legion");
        }
    }
}