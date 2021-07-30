package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class LoginController {
    private User user;
    protected Connection conn;

    @FXML
    Button btnLogin;

    public LoginController(Connection conn) {
        this.conn = conn;
    }

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
                "USERNAME, FIRSTNAME, LASTNAME, DATEOFBIRTH, EMAIL, PASSWORD, ROLE, ACTIVE) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', true)",
                inputUsername, inputFirstname, inputLastname, inputDateOfBirth, inputEmail, inputPassword, inputRole));
    }

    @FXML
    public void login() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        String inputUsername = scanner.nextLine();
        String inputPassword = scanner.nextLine();
        int id = 0;

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(String.format("SELECT USERNAME, PASSWORD FROM USER WHERE USERNAME = %s", inputUsername));
        String valueUsername ="";
        String valuePassword ="";
        if (resultSet.next()) {
            valueUsername = resultSet.getString("USERNAME");
            valuePassword = resultSet.getString("PASSWORD");
        }
        if (inputUsername.equals(valueUsername)) {
            String message = "GEILER SCHEISS!";
            int i = 0;
        }

//        statement.executeUpdate(String.format("SELECT USERNAME AND PASSWORD FROM USER WHERE id = %d", id));
    }
}
