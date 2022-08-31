import java.util.Arrays;

public class Land extends Grid {

    @Override
    public String toString() {
        return "\nWelcome to Humans vs Goblins!\n\n" +
                "************************************\n" +
                Arrays.deepToString(grid).replace("], ", "]\n") +
                "\n************************************";
    }
}
