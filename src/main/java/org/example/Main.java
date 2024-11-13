package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Connection connection = DbConnection.getConnection();
        if (connection != null) {
            System.out.println("Connected to the database");
            DbConnection.closeConnection();
        }
    }
}