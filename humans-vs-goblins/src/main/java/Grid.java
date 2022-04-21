import java.util.Arrays;

public class Grid {

    char[][] grid = {
            {'=','=','=','=','=','='},
            {'-','-','-','-','-','-'},
            {'-','-','-','-','-','-'},
            {'-','-','-','-','-','-'},
            {'-','-','-','-','-','-'},
            {'=','=','=','=','=','='}
    };

    @Override
    public String toString() {
        return "I AM THE GAME GRID!\n"; //
                //Arrays.deepToString(grid).replace("], ", "]\n");
    }

}   // Class
