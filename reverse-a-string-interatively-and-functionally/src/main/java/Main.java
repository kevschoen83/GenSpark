import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Main.reverseIterative("String"));
        System.out.println(Main.reverseFunctional("abcdefd"));
    }

    // Reverse a string iteratively
    public static String reverseIterative(String word) {
        String solution = "";
        char[] charArray = word.toCharArray();

        for (int i = charArray.length - 1; i >= 0; i--) {
            solution += charArray[i];
        }

        return solution;
    }

    //Reverse a string functionally
    public static String reverseFunctional(String word) {
        String solution = Arrays.stream(word.split(""))
                .reduce((acc, next) -> next + acc)
                .orElse("");

        return solution;
    }
}




