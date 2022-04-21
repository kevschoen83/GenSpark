public class Human {
    private int startingRow;
    private int startingColumn;
    private int currentRow;
    private int currentColumn;
    private int nextRow;
    private int nextColumn;
    private int maxHealth;
    private int currentHealth;
    private int strength;

    char human = 'H';

    @Override
    public String toString() {
        return "I am a Human object.";
    }

    Human() {
       // System.out.println("Human object created!");
/*        setStartingRow(5);
        setStartingColumn(3);*/
    }

    // GETTERS
    public int getStartingRow() { return startingRow; }
    public int getStartingColumn() { return startingColumn; }
    public int getCurrentRow() { return currentRow; }
    public int getCurrentColumn() { return currentColumn; }
    public int getNextRow() { return nextRow; }
    public int getNextColumn() { return nextColumn; }
    public int getStrength() { return strength; }

    // SETTERS
    public void setStartingRow(int startingRow) { this.startingRow = startingRow; }
    public void setStartingColumn(int startingColumn) { this.startingColumn = startingColumn; }
    public void setCurrentRow(int currentRow) { this.currentRow = currentRow; }
    public void setCurrentColumn(int currentColumn) { this.currentColumn = currentColumn; }
    public void setNextRow(int nextRow) { this.nextRow = nextRow; }
    public void setNextColumn(int nextColumn) { this.nextColumn = nextColumn; }
    public void setStrength(int strength) { this.strength = strength; }

    void attack(int strength) {

    }
}
