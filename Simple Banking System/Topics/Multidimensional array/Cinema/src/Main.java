import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] seats = new int[n][m];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();

        int counter = 0;
        int row = 0;
        boolean done = false;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (seats[i][j] == 0) {
                    counter++;
                    if (counter == k) {
                        row = i;
                        break;
                    }
                }
            }
            if (done) {
                break;
            }
            counter = 0;
        }

        System.out.println(row);

    }
}