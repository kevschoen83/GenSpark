package RegexPractice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckLoginProblem {

    public static void main(String[] args) {

        String text = "Java supports regular expressions. LET'S USE JAVA!!!";

        Pattern javaPattern = Pattern.compile("java", Pattern.CASE_INSENSITIVE);
        Matcher javaMatcher = javaPattern.matcher(text);

        Pattern regexPattern = Pattern.compile(".*regular expression.*");
        Matcher regexMatcher = regexPattern.matcher(text);

        System.out.println(Pattern.matches(".*java.*", text));
        System.out.println(javaMatcher.find());
        System.out.println(regexMatcher.matches());
        System.out.println(javaMatcher.matches());
        System.out.println(regexMatcher.find());

        /*

        */
/* The scanner object to read data from the standard input *//*

        Scanner scanner = new Scanner(System.in);

        */
/* The common pattern for valid logins *//*

        String loginRegex = "\\s*[a-zA-Z0-9_$]{5,12}\\s*";

        */
/* The read string which may be a login *//*

        String mayBeLogin = scanner.nextLine();

        boolean isLogin = mayBeLogin.matches(loginRegex);

        System.out.println(isLogin);
*/

    }

}
