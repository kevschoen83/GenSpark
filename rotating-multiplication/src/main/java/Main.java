import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = {1,5,3,6,2};
        System.out.println(Arrays.toString(Main.rotatingMultiplication(test)));
    }

    public static int[] rotatingMultiplication(int[] nums) {
        int[] solution = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    temp *= nums[j];
                }
            }
            solution[i] = temp;
        }

        return solution;
    }

}

/*    Rotating Multiplication (30 minutes)

    Return the Product of Array Except Self.

        Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal
        to the product of all the elements of nums except nums[i].

        Constraint: cannot use division.

public static void main(String[] args) {
        int[] test = {2, 5, 6, 4};
        }
public static int[] product(int[] nums) {
        return null;
        }

        Input => {2, 5, 6,  4}
        Output => [120, 48, 40, 60]*/
