import java.util.Arrays;

public class Land extends Grid {
    @Override
    public String toString() {
        return "I am a Land object.\nI extend the Grid object...\n"; //+
                //Arrays.deepToString(grid).replace("], ", "]\n");
    }

    Land() {
        grid[0][3] = 'G';
        grid[5][3] = 'H';
    }

    void displayGrid() {
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
    }

    void updateHumanGrid(int oldRow, int oldColumn, int newRow, int newColumn) {
        grid[oldRow][oldColumn] = '-';
        grid[newRow][newColumn] = 'H';
        displayGrid();
    }

    void updateGoblinGrid(int row, int column) {
        grid[row][column] = 'G';
        displayGrid();
    }
}
