public class Main {
    public static void main(String[] args) {
        boolean isPlaying = true;

        //while (isPlaying) {
            Land land = new Land();
            Human human = new Human();
            Goblin goblin = new Goblin();
            System.out.println(land);

            land.displayGrid();
            System.out.println();
            land.updateHumanGrid(5, 3, 4,3);
            land.updateGoblinGrid(2, 4);
        //}
    }
}