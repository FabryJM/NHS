package controller;

import model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class LoginController {
    private User user;

    public void register(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String inputUsername = scanner.nextLine();
        String inputFirstname = scanner.nextLine();
        String inputLastname = scanner.nextLine();
        String inputDateOfBirth = scanner.nextLine();
        String inputEmail = scanner.nextLine();
        String inputPassword = scanner.nextLine();
        String inputRole = scanner.nextLine();

        Statement statement = connection.createStatement();
        statement.executeUpdate(String.format("INSERT INTO patient (" +
                "USERNAME, FIRSTNAME, LASTNAME, DATEOFBIRTH, EMAIL, PASSWORD, ROLE) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                inputUsername, inputFirstname, inputLastname, inputDateOfBirth, inputEmail, inputPassword, inputRole));
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        String inputUsername = scanner.nextLine();
        String inputPassword = scanner.nextLine();

    }

}
