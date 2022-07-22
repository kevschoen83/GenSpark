package banking;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Menu {

    private boolean loggedIn = false;
    private String loggedInNumber = "";
    boolean isFirstLogin = false;

    void displayMenu() {
        if (!isLoggedIn()) {
            displayLoggedOutOptions();
            int input = (int) getUserInput();
            System.out.println();

            if (input == 1) {
                Card newCard = new Card();
                displayMenu();
            } else if (input == 2) {
                getUserLoginInfo();
            } else if (input == 0) {
                System.out.println("Bye!");
            }
        } else {
            displayLoggedInOptions();
            int input = (int) getUserInput();
            System.out.println();

            switch (input) {
                case 1:
                    System.out.println("Balance: " + Database.checkBalance(getLoggedInNumber()));
                    System.out.println();
                    displayMenu();
                    break;
                case 2:
                    System.out.println("Enter income:");
                    int income = (int) getUserInput();
                    Database.updateBalance(getLoggedInNumber(), income);
                    System.out.println("Income was added!");
                    System.out.println("Balance: " + Database.checkBalance(getLoggedInNumber()));
                    System.out.println();
                    displayMenu();
                    break;
                case 3:
                    System.out.println(getLoggedInNumber());
                    System.out.println("Transfer");
                    System.out.println("Enter card number:");
                    Scanner scanner = new Scanner(System.in);
                    String transfer = scanner.next();
                    scanner.close();
                    transferChecks(transfer);
                    break;
                case 4:
                    Database.deleteCard(getLoggedInNumber());
                    loggedIn = false;
                    System.out.println("The account has been closed!");
                    System.out.println();
                    displayMenu();
                    break;
                case 5:
                    setLoggedIn(false);
                    displayMenu();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
            }
        }
    }

    void transferChecks(String accountNumber) {
        if (!accountNumber.equals(String.valueOf(Card.luhnAlgorithm(numberConverter(accountNumber))))) {
            Database.checkBalance(getLoggedInNumber());
            System.out.println("Probably you made a mistake in the card number. Please try again!");
            System.out.println();
            displayMenu();
        } else if (!Database.numExists(accountNumber)) {
            System.out.println("Such a card does not exist.");
            System.out.println();
            displayMenu();
        } else {
            System.out.println("Enter how much money you want to transfer:");
            long amount = getUserInput();
            if (!fundsCheck(getLoggedInNumber(), amount)) {
                System.out.println("Not enough money!");
                System.out.println();
                displayMenu();
            } else {
                Database.transferFunds(getLoggedInNumber(), accountNumber, amount);
                System.out.println("Success!");
                System.out.println();
                displayMenu();
            }
        }
    }

    boolean fundsCheck(String accountNumber, long amount) {
        long fundsInAccount = Long.parseLong(Database.checkBalance(accountNumber));
        System.out.println("fundsInAccount: " + fundsInAccount);
        if (amount > fundsInAccount) {
            return false;
        } else {
            return true;
        }
    }

    // Prepare the account number to be entered into the Luhn Algorithm for authentication
    String numberConverter(String accountNumber) {
        long num = Long.parseLong(accountNumber);
        num /= 10;
        return String.valueOf(num);
    }

    void getUserLoginInfo() {
        System.out.println("Enter your card number:");
        String enteredNumber = String.valueOf(getUserInput());
        System.out.println("Enter your PIN:");
        int enteredPIN = (int) getUserInput();

        if (!Database.checkNumber(enteredNumber, String.valueOf(enteredPIN))) {
            System.out.println();
            System.out.println("Wrong card number or PIN!");
            System.out.println();
            displayMenu();
        } else {
            setLoggedInNumber(enteredNumber);
            System.out.println();
            System.out.println("You have successfully logged in!");
            System.out.println("Logged In Number = " + getLoggedInNumber());
            System.out.println();
            loggedIn = true;
            displayMenu();
        }
    }

    long getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    void displayLoggedOutOptions() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }

    void displayLoggedInOptions() {
        System.out.println("1. Balance");
        System.out.println("2. Add income");
        System.out.println("3. Do transfer");
        System.out.println("4. Close account");
        System.out.println("5. Log out");
        System.out.println("0. Exit");
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getLoggedInNumber() {
        return loggedInNumber;
    }

    public void setLoggedInNumber(String loggedInNumber) {
        this.loggedInNumber = loggedInNumber;
    }
}
