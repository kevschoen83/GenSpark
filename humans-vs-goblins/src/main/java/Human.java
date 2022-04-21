public class Human {
    private int[][] currentPosition;
    private int[][] nextPosition;
    private int[][] previousPosition;

    char human = 'H';

    @Override
    public String toString() {
        return "I am a Human object.";
    }

    Human() {
       // System.out.println("Human object created!");
    }
}
