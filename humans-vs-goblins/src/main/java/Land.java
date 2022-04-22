import java.util.Arrays;

public class Land extends Grid {
    @Override
    public String toString() {
        return "I am a Land object.\nI extend the Grid object...\n" +
                "\n" +
                "Welcome to Humans Vs Goblins!";
    }

    Land() {
        grid[2][2] = 'G';
        //grid[3][1] = 'G';
        grid[5][3] = 'H';
    }

    void displayGrid() {
        System.out.println("+++++++++++++++++++");
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
        System.out.println("+++++++++++++++++++");
    }

    void updateHumanGrid(int oldRow, int oldColumn, int newRow, int newColumn) {
        grid[oldRow][oldColumn] = '-';
        grid[newRow][newColumn] = 'H';
        displayGrid();
    }

    void updateGoblinGrid(int oldRow, int oldColumn) {
        grid[oldRow][oldColumn] = '-';
        //grid[newRow][newColumn] = 'G';
        displayGrid();
    }

    void newGame() {
        Land land = new Land();
    }
}
