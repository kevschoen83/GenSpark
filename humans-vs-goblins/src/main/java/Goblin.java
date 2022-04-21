public class Goblin {
    private int startingRow;
    private int startingColumn;
    private int currentRow;
    private int currentColumn;
    private int nextRow;
    private int nextColumn;
    private int maxHealth;
    private int currentHealth;

    char goblin = 'G';

    @Override
    public String toString() {
        return "I am a Goblin object";
    }

    Goblin() {
        //System.out.println("Goblin object created!");
    }

    // GETTERS
    public int getStartingRow() { return startingRow; }
    public int getStartingColumn() { return startingColumn; }
    public int getCurrentRow() { return currentRow; }
    public int getCurrentColumn() { return currentColumn; }
    public int getNextRow() { return nextRow; }
    public int getNextColumn() { return nextColumn; }
    public int getMaxHealth() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }

    // SETTERS
    public void setStartingRow(int startingRow) { this.startingRow = startingRow; }
    public void setStartingColumn(int startingColumn) { this.startingColumn = startingColumn; }
    public void setCurrentRow(int currentRow) { this.currentRow = currentRow; }
    public void setCurrentColumn(int currentColumn) { this.currentColumn = currentColumn; }
    public void setNextRow(int nextRow) { this.nextRow = nextRow; }
    public void setNextColumn(int nextColumn) { this.nextColumn = nextColumn; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setCurrentHealth(int currentHealth) { this.currentHealth = currentHealth; }
}
