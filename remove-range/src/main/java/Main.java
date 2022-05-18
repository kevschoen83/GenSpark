import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        nums.add(7);
        nums.add(8);
        nums.add(9);
        nums.add(10);

        System.out.println(Main.removeRange(nums, 4, 6));

    }

    static ArrayList<Integer> removeRange(ArrayList<Integer> nums, int from, int to) {
        ArrayList<Integer> solution = new ArrayList<>();

        solution = (ArrayList<Integer>) nums.stream()
                .filter(f -> f < from || f > to)
                .collect(Collectors.toList());

        return solution;
    }
}

/*
    Remove Range (10 minutes)

    Create a new Java Project with a Main method.
        Create a method that will take in an ArrayList of Integers called nums, an int called from, an int called to as parameters.
        In your method you need to remove the range of integers that start at from and end at to inclusive, the range is not based
            on index it is based on the value of from  to
        Call the method you created from main.
        Print your result to the console from main. */