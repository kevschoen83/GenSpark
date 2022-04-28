public class ReverseAnInteger {
    public static void main(String[] args) {

        System.out.println(ReverseAnInteger.ReverseAnInteger(20541));

    }

    public static int ReverseAnInteger(int num) {
        String str = "";
        str = String.valueOf(num);
        char[] arr = str.toCharArray();
        String reversed = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            reversed += arr[i];
        }

        return Integer.parseInt(reversed);
    }

}

/*    Reverse an Integer (10 minutes)

    Create a new Java Project with a Main method.
        Create a method that will take in an int as a parameter.
        In your method reverse the int that is passed in and then return the new reversed int.
        Call the method you created from main.
        When calling the method, give it an argument of an Integer that will be reversed.
        Print  your result to the console from main. This should be the reverse of whatever you passed to your method.
        NO STRING BUILDER*/