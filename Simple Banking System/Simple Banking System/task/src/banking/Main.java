package banking;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:card.s3db");

//        Database.createNewDatabase("card.s3db");

        Database.createNewDatabase(args[1]);

        Menu menu = new Menu();
        menu.displayMenu();
    }
}
