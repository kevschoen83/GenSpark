import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        boolean isPlaying = true;

        // create land grid object
        Land land = new Land();
        // create human object and set strength
        Human human = new Human();
        human.setStrength(1);
        human.setHitChance(10);

        //create goblin objects and set max health, then set current health = max health
        Goblin goblin = new Goblin();
        Goblin goblin1 = new Goblin();
        goblin.setMaxHealth(5);
        goblin.setCurrentHealth(goblin.getMaxHealth());
        goblin.setDefense(3);
        System.out.println("goblin health: " + goblin.getCurrentHealth());
        goblin1.setMaxHealth(3);
        goblin1.setDefense(3);
        goblin1.setCurrentHealth(goblin1.getMaxHealth());
        System.out.println("goblin1 health: " + goblin1.getCurrentHealth());

        // set human starting position
        human.setStartingRow(5);
        human.setStartingColumn(3);
        human.setCurrentRow(human.getStartingRow());
        human.setCurrentColumn(human.getStartingColumn());
        // set goblins starting positions
        goblin.setStartingRow(2);
        goblin.setStartingColumn(2);
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
                        if (goblin != null && human.getNextRow() == goblin.getCurrentRow() && human.getNextColumn() == goblin.getCurrentColumn()) {
                            //double hit = Math.random() * 10;
                            System.out.println("ATTACK!");
                            int hit = (int) ((Math.random() * 10));
                            System.out.println("hit: " + hit);
                            if (hit < (human.getHitChance() - goblin.getDefense())) {
                                System.out.println("HIT!");
                                goblin.setCurrentHealth(goblin.getCurrentHealth() - human.getStrength());
                                System.out.println("Goblin hit.\n" +
                                        "current health: " + goblin.getCurrentHealth());
                                land.displayGrid();
                                if (goblin.getCurrentHealth() <= 0) {
                                    System.out.println("Goblin Destroyed!");
                                    land.updateGoblinGrid(goblin.getCurrentRow(), goblin.getCurrentColumn());
                                    goblin = null;
                                }
                            } else {
                                System.out.println("MISSED!");
                            }
                        }
                        else {
                            land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                            human.setCurrentRow(human.getNextRow());
                            human.setCurrentColumn(human.getNextColumn());
                        }
                        break;
                    case "a":
                        // human moves left
                        human.setNextRow(human.getCurrentRow());
                        human.setNextColumn(human.getCurrentColumn() - 1);
                        if (goblin != null && human.getNextColumn() == goblin.getCurrentColumn() && human.getNextRow() == goblin.getCurrentRow()) {
                            System.out.println("ATTACK!");
                            int hit = (int) ((Math.random() * 10));
                            System.out.println("hit: " + hit);
                            if (hit < (human.getHitChance() - goblin.getDefense())) {
                                System.out.println("HIT!");
                                goblin.setCurrentHealth(goblin.getCurrentHealth() - human.getStrength());
                                System.out.println("Goblin hit.\n" +
                                        "current health: " + goblin.getCurrentHealth());
                                land.displayGrid();
                                if (goblin.getCurrentHealth() <= 0) {
                                    System.out.println("Goblin Destroyed!");
                                    land.updateGoblinGrid(goblin.getCurrentRow(), goblin.getCurrentColumn());
                                    goblin = null;
                                }
                            } else {
                                System.out.println("MISSED!");
                            }
                        } else {
                            land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                            human.setCurrentRow(human.getNextRow());
                            human.setCurrentColumn(human.getNextColumn());
                        }
                        break;
                    case "d":
                        // human moves right
                        human.setNextRow(human.getCurrentRow());
                        human.setNextColumn(human.getCurrentColumn() + 1);
                        if (goblin != null && human.getNextColumn() == goblin.getCurrentColumn() && human.getNextRow() == goblin.getCurrentRow()) {
                            System.out.println("ATTACK!");
                            int hit = (int) ((Math.random() * 10));
                            System.out.println("hit: " + hit);
                            if (hit < (human.getHitChance() - goblin.getDefense())) {
                                System.out.println("HIT!");
                                goblin.setCurrentHealth(goblin.getCurrentHealth() - human.getStrength());
                                System.out.println("Goblin hit.\n" +
                                        "current health: " + goblin.getCurrentHealth());
                                land.displayGrid();
                                if (goblin.getCurrentHealth() <= 0) {
                                    System.out.println("Goblin Destroyed!");
                                    land.updateGoblinGrid(goblin.getCurrentRow(), goblin.getCurrentColumn());
                                    goblin = null;
                                }
                            } else {
                                System.out.println("MISSED!");
                            }
                        } else {
                            land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                            human.setCurrentRow(human.getNextRow());
                            human.setCurrentColumn(human.getNextColumn());
                        }
                        break;
                    case "s":
                        // human moves down
                        human.setNextRow(human.getCurrentRow() + 1);
                        human.setNextColumn(human.getCurrentColumn());
                        if (goblin != null && human.getNextRow() == goblin.getCurrentRow() && human.getNextColumn() == goblin.getCurrentColumn()) {
                            System.out.println("ATTACK!");
                            int hit = (int) ((Math.random() * 10));
                            System.out.println("hit: " + hit);
                            if (hit < (human.getHitChance() - goblin.getDefense())) {
                                System.out.println("HIT!");
                                goblin.setCurrentHealth(goblin.getCurrentHealth() - human.getStrength());
                                System.out.println("Goblin hit.\n" +
                                        "current health: " + goblin.getCurrentHealth());
                                land.displayGrid();
                                if (goblin.getCurrentHealth() <= 0) {
                                    System.out.println("Goblin Destroyed!");
                                    land.updateGoblinGrid(goblin.getCurrentRow(), goblin.getCurrentColumn());
                                    goblin = null;
                                }
                            } else {
                                System.out.println("MISSED!");
                            }
                        } else {
                            land.updateHumanGrid(human.getCurrentRow(), human.getCurrentColumn(), human.getNextRow(), human.getNextColumn());
                            human.setCurrentRow(human.getNextRow());
                            human.setCurrentColumn(human.getNextColumn());
                        }
                        break;
                    default:
                        System.out.println("Incorrect input.  Please use the w,a,s,d keys on the keyboard to move.");
                        break;
                }
                //land.updateGoblinGrid(0, 3,2, 4);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Out of bounds...Game Over!");
                isPlaying = false;
            }
        }
    }

}