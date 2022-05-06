import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private String name;
    private int score;

    // GETTERS
    public String getName() { return name; }
    public int getScore() { return score; }
    //SETTERS
    public void setName(String name) { this.name = name; }
    public void setScore(int score) { this.score = score; }

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Hangman!");
        Main hangmanGame = new Main();
        hangmanGame.newGame();
        hangmanGame.play();
    }

    public static final String[] WORDS = {"abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "double", "do", "else",
            "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements",
            "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package",
            "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile",
            "while"};

    public static final Random RANDOM = new Random();

    // Max errors before player loses game
    public static final int MAX_ERRORS = 7;

    // Word to find
    private String wordToFind;

    // Word found stored in a char array to show progression of player
    private char[] wordFound;
    private int nbErrors;

    // letters already entered by the user
    private ArrayList<String> letters = new ArrayList<>();

    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    public void writePlayerInfoToFile(String name, int score) throws IOException {
        String fileName = "C:\\GenSpark\\GenSpark\\hangman-functional\\src\\main\\resources" +
                "\\Name-Score";
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(name);
        writer.newLine();
        writer.write("" + score);
        writer.close();
    }

    public void newGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        setName(scanner.next());
        System.out.println("Welcome " + getName() + "!");
        setScore(0);
        System.out.println(getScore());
        writePlayerInfoToFile(getName(), getScore());
//        System.out.println(checkForHighScore());

        nbErrors = 0;
        letters.clear();
        wordToFind = nextWordToFind();

        // word found initialization
        wordFound = new char[wordToFind.length()];

        for (int i = 0; i < wordFound.length; i++) {
            wordFound[i] = '_';
        }
    }

    public boolean wordFound() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);

            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    private void enter(String c) throws IOException {
        String[] hangman;
        Path path = Paths.get("C:\\GenSpark\\GenSpark\\hangman-functional\\src\\" +
                        "main\\resources\\Hangman-Art");
        // we update only if c has not already been entered
        if (!letters.contains(c)) {
            // we check if word to find contains c
            if (wordToFind.contains(c)) {
                // increase the score
                setScore(getScore() + 10);
                System.out.println("Score: " + getScore());
                // if so, we replace _ by the character c
                int index = wordToFind.indexOf(c);

                while (index >= 0) {
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                // c not in the word => error
                nbErrors++;
                try {
                    hangman = Files.readString(path).split(",");
                    System.out.println(hangman[nbErrors - 1]);
                    System.out.println("Score: " + getScore());
                } catch (IOException ignored) { }
            }

            // c is now a letter entered
            letters.add(c);
        } else {
            try {
                hangman = Files.readString(path).split(",");
                System.out.println(hangman[nbErrors - 1]);
                System.out.println("Score: " + getScore());
            } catch (IOException ignored) { }

            System.out.println("Letter already entered!  Please try again.");
        }
    }

/*    so to determine that the mystery word has 3 As in it, i used a filter
    and i revealed those As with a map*/

    public void play() throws IOException{
        try (Scanner input = new Scanner(System.in)) {
            // we play while nbErrors is lower than max errors or user has found the word
            while (nbErrors < MAX_ERRORS) {
                System.out.println("\nEnter a letter: ");
                // get next input from user
                String str = input.next();

                // we keep just first letter
                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }

                // update word found
                enter(str);

                // display current state
                System.out.println("\n" + wordFoundContent());

                // check if word is found
                if (wordFound()) {
                    System.out.println("\nYou win!");
                    writePlayerInfoToFile(getName(), getScore());
                    checkForHighScore();
                    break;
                } else {
                    // we display nb tries remaining for the user
                    System.out.println("\n=> Nb tries remaining: " + (MAX_ERRORS - nbErrors));
                }
            }

            if (nbErrors == MAX_ERRORS) {
                // user loses
                System.out.println("\nYou lose!");
                System.out.println("=> Word to find was: " + wordToFind);
            }
        }
    }

    public void checkForHighScore() throws IOException {
        File file = new File("C:\\\\GenSpark\\\\GenSpark\\\\hangman-functional\\\\src" +
                "\\\\main\\\\resources\\\\Name-Score");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        System.out.println("Test");
        int readScore = scanner.nextInt();
        System.out.println(readScore);
        if (getScore() > scanner.nextInt()) {
            System.out.println("New High Score!");
        }
    }

/*    public int checkForHighScore() throws IOException {
//        String fileName = "C:\\GenSpark\\GenSpark\\hangman-functional\\src\\main\\resources\\Name-Score";

        File file = new File("C:\\GenSpark\\GenSpark\\hangman-functional\\src" +
                "\\main\\resources\\Name-Score");
        Scanner scanner = new Scanner(file);
        scanner.nextLine();
        return scanner.nextInt();
*//*        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = reader.readLine()) != null) {
            line += line;
        }
        return line;*//*
    }*/
}