import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            if (i == size - 1) {
                array[0] = array[i];
            } else {
                array[i + 1] = array[i];
            }
        }

        System.out.println(Arrays.toString(array));
    }
}