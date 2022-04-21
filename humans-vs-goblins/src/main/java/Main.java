import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        boolean isPlaying = true;

        Land land = new Land();
        Human human = new Human();
        human.setStrength(1);
        Goblin goblin = new Goblin();
        goblin.setMaxHealth(5);
        goblin.setCurrentHealth(goblin.getMaxHealth());

        human.setStartingRow(5);
        human.setStartingColumn(3);
        human.setCurrentRow(human.getStartingRow());
        human.setCurrentColumn(human.getStartingColumn());
        goblin.setStartingRow(0);
        goblin.setStartingColumn(3);
        goblin.setCurrentRow(goblin.getStartingRow());
        goblin.setCurrentColumn(goblin.getStartingColumn());

        System.out.println(land); // prints starting text

        land.displayGrid(); // displays starting grid

        while (isPlaying) {

            try {
                input = scanner.nextLine();

                switch (input) {
                    case "w":
                        // human moves up
                        human.setNextRow(human.getCurrentRow() - 1);
                        human.setNextColumn(human.getCurrentColumn());
                        if (human.getNextRow() == goblin.getCurrentRow() && human.getNextColumn() == goblin.getCurrentColumn()) {
                            System.out.println("ATTACK!");
                            goblin.setCurrentHealth(goblin.getCurrentHealth() - human.getStrength());
                            System.out.println("Goblin hit.\n" +
                                    "current health: " + goblin.getCurrentHealth());
                            land.displayGrid();
                        } else {
                            land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                            human.setCurrentRow(human.getNextRow());
                            human.setCurrentColumn(human.getNextColumn());
                        }
                        break;
                    case "a":
                        // human moves left
                        human.setNextRow(human.getCurrentRow());
                        human.setNextColumn(human.getCurrentColumn() - 1);
                        land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                        human.setCurrentRow(human.getNextRow());
                        human.setCurrentColumn(human.getNextColumn());
                        break;
                    case "d":
                        // human moves right
                        human.setNextRow(human.getCurrentRow());
                        human.setNextColumn(human.getCurrentColumn() + 1);
                        land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                        human.setCurrentRow(human.getNextRow());
                        human.setCurrentColumn(human.getNextColumn());
                        break;
                    case "s":
                        // human moves down
                        human.setNextRow(human.getCurrentRow() + 1);
                        human.setNextColumn(human.getCurrentColumn());
                        land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                        human.setCurrentRow(human.getNextRow());
                        human.setCurrentColumn(human.getNextColumn());
                        break;
                    default:
                        System.out.println("Incorrect input.  Please use the w,a,s,d keys on the keyboard to move.");
                        break;
                }
                //land.updateGoblinGrid(0, 3,2, 4);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out of bounds...GAME OVER!");
                isPlaying = false;
            }
        }
    }

}