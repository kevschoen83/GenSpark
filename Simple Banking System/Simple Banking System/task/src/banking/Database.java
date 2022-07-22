package banking;

import org.sqlite.SQLiteDataSource;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Database {

    static SQLiteDataSource dataSource = new SQLiteDataSource();

    static boolean closeConn = false;

    static void createNewDatabase(String fileName) {
        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                if (closeConn) {
                    conn.close();
                } else {
                    DatabaseMetaData meta = conn.getMetaData();
                    createNewTable(conn);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    static void createNewTable(Connection con) {
        dataSource.setUrl("card.s3db");

        try (con) {
            // Statement creation
            try (Statement statement = con.createStatement()) {
                // Statement execution
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS card(" +
                        "id INTEGER PRIMARY KEY," +
                        "number TEXT," +
                        "pin TEXT," +
                        "balance INTEGER DEFAULT 0)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addCard(String number, String pin, String balance) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                int i = statement.executeUpdate("INSERT INTO card (number, pin, balance) VALUES " +
                        "(" + number + ", " + pin + ", " + balance + ")");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static boolean checkNumber(String accountNumber, String pin) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM card " +
                        "WHERE number = " + accountNumber + " AND pin = " + pin);
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    static boolean numExists(String accountNumber) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM card " +
                        "WHERE number = " + accountNumber);
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    static String checkBalance(String accountNumber) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                return statement.executeQuery("SELECT balance FROM card " +
                        "WHERE number = " + accountNumber).getString("balance");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accountNumber;
    }

    static void updateBalance(String accountNumber, int amount) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                int i = statement.executeUpdate("UPDATE card " +
                        "SET balance = balance + " + amount +
                        " WHERE number = " + accountNumber);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void transferFunds(String from, String to, long amount) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                int i = statement.executeUpdate("UPDATE card " +
                        "SET balance = balance - " + amount +
                        " WHERE number = " + from);
                int u = statement.executeUpdate("UPDATE card " +
                        "SET balance = balance + " + amount +
                        " WHERE number = " + to);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void deleteCard(String accountNumber) {
        dataSource.setUrl("jdbc:sqlite:card.s3db");

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                int i = statement.executeUpdate("DELETE FROM card " +
                        "WHERE number = " + accountNumber);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    static void closeConnection() {
        closeConn = true;
    }

}
