import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];

        boolean solution = true;

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            if (i > 0) {
                if (array[i] <= array[i - 1]) {
                    solution = false;
                    break;
                }
            }
        }

        System.out.println(solution);

    }
}