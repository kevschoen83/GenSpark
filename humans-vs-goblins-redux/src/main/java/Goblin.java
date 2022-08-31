public class Goblin {
    private int startingRow;
    private int startingColumn;
    private int currentRow;
    private int currentColumn;
    private int nextRow;
    private int nextColumn;
    private int maxHealth;
    private int currentHealth;
    private int defense;

    @Override
    public String toString() {
        return "Goblin{\n" +
                "startingRow=" + startingRow +
                ", startingColumn=" + startingColumn +
                ", currentRow=" + currentRow +
                ", currentColumn=" + currentColumn +
                ", nextRow=" + nextRow +
                ", \nnextColumn=" + nextColumn +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", defense=" + defense +
                '}';
    }

    public int getStartingRow() {
        return startingRow;
    }

    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }

    public int getStartingColumn() {
        return startingColumn;
    }

    public void setStartingColumn(int startingColumn) {
        this.startingColumn = startingColumn;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    public void setCurrentColumn(int currentColumn) {
        this.currentColumn = currentColumn;
    }

    public int getNextRow() {
        return nextRow;
    }

    public void setNextRow(int nextRow) {
        this.nextRow = nextRow;
    }

    public int getNextColumn() {
        return nextColumn;
    }

    public void setNextColumn(int nextColumn) {
        this.nextColumn = nextColumn;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
