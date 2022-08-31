public class Main {
    public static void main(String[] args) {
//        Grid grid = new Grid();
//        System.out.println(grid);

        Land land = new Land();
        System.out.println(land);

        Human human = new Human();
        System.out.println(human);
        System.out.println();
        Goblin goblin = new Goblin();
        System.out.println(goblin);

        Console userInput = new Console();
        userInput.getInput();
    }
}
