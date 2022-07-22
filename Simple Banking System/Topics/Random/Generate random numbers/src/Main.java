import java.util.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = 0;

        Random random = new Random(a + b);

        for (int i = 0; i < n; i++) {
            sum += random.nextInt((a - b + 1) + a);
        }

        System.out.println(sum);
    }
}

/*
    the seed when you are creating an object should be (from + upto)
    and when you call a generator (upto - from + 1) + from*/
