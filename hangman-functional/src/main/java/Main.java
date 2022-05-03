import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
    public static final int MAX_ERRORS = 6;

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

    public void newGame() {
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

    private void enter(String c) {
        // we update only if c has not already been entered
        if (!letters.contains(c)) {
            // we check if word to find contains c
            if (wordToFind.contains(c)) {
                // if so, we replace _ by the character c
                int index = wordToFind.indexOf(c);

                while (index >= 0) {
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {
                // c not in the word => error
                nbErrors++;
            }

            // c is now a letter entered
            letters.add(c);
        }
    }

    public void play() {
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
}
