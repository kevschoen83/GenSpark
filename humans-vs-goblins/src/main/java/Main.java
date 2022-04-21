import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        boolean isPlaying = true;

        Land land = new Land();
        Human human = new Human();
        Goblin goblin = new Goblin();

        human.setStartingRow(5);
        human.setStartingColumn(3);
        human.setCurrentRow(human.getStartingRow());
        human.setCurrentColumn(human.getStartingColumn());

        System.out.println(land); // prints starting text

        while (isPlaying) {
/*            goblin.setStartingRow(0);
            goblin.setStartingColumn(3);*/

            land.displayGrid(); // displays starting grid

            try {
                input = scanner.nextLine();

                if (input.equals("w")) {
                    // human moves up
                    human.setNextRow(human.getCurrentRow() - 1);
                    human.setNextColumn(human.getCurrentColumn());
                    land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                    human.setCurrentRow(human.getNextRow());
                    human.setCurrentColumn(human.getNextColumn());
                } else if (input.equals("a")) {
                    // human moves left
                    human.setNextRow(human.getCurrentRow());
                    human.setNextColumn(human.getCurrentColumn() - 1);
                    land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                    human.setCurrentRow(human.getNextRow());
                    human.setCurrentColumn(human.getNextColumn());
                } else if (input.equals("d")) {
                    // human moves right
                    human.setNextRow(human.getCurrentRow());
                    human.setNextColumn(human.getCurrentColumn() + 1);
                    land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                    human.setCurrentRow(human.getNextRow());
                    human.setCurrentColumn(human.getNextColumn());
                } else if (input.equals("s")) {
                    // human moves down (if allowed)
                    human.setNextRow(human.getCurrentRow() + 1);
                    human.setNextColumn(human.getCurrentColumn());
                    land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                    human.setCurrentRow(human.getNextRow());
                    human.setCurrentColumn(human.getNextColumn());
                } else {
                    System.out.println("Incorrect input.  Please use the w,a,s,d keys on the keyboard to move.");
                }
                //land.updateGoblinGrid(0, 3,2, 4);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out of bounds...GAME OVER!");
                isPlaying = false;
            }
        }
    }

}