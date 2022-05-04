public class Main {
    public static void main(String[] args) {
        System.out.println("Divisible by 3 & 5: " + Main.fizzBuzzBazz(90));
        System.out.println("Divisible by 5: " + Main.fizzBuzzBazz(10));
        System.out.println("Divisible by 3: " + Main.fizzBuzzBazz(9));
        System.out.println("Divible by neither: " + Main.fizzBuzzBazz(1));
    }

    public static String fizzBuzzBazz(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "fizz buzz bazz";
        } else if (num % 5 == 0) {
            return "buzz";
        } else if (num % 3 == 0) {
            return "fizz";
        } else {
            return "Num is not divisible by 3 or 5";
        }
    }
}



/*  Fizz Buzz Bazz (5 minutes)

    Create a new Java Project with a Main method.
        Create a method that will take in an Integer as a parameter.

        In your method you need to check to see if the integer is divisible by 3 and
        if it is then you will need to return fizz, if it's divisible by 5 then return buzz,
        and lastly if it's divisible by 3 and 5 return fizz buzz bazz.

        Call the method you created from main.

        Print  your result to the console from main. */
