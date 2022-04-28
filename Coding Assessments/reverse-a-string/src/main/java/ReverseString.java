public class ReverseString {
    public static void main(String[] args) {

        System.out.println(reverseString("FINALLY"));

    }

    static String reverseString(String str) {
        char[] arr = str.toCharArray();
        String solution = "";
        for (int i = arr.length-1; i >= 0; i--) {
            solution += arr[i];
        }

        return solution;
    }

}


/*
    Create a new Java Project with a Main method.
        Create a method that will take in a String as a parameter.
        In your method reverse the String that is passed in and then return the new reversed String.
        Call the method you created from main.
        When calling the method, give it an argument of a string that will be reversed.
        Print your result to the console from main. This should be the reverse of whatever you passed to your method.
        No String Builder
*/
