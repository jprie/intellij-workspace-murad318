package com.example.logindatabasegx.Controller;

import com.example.logindatabasegx.DatabaseUtility;
import com.example.logindatabasegx.LoginDatabaseApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameTf;
    @FXML
    private PasswordField passwordTf;
    @FXML
    private Label errorMessageLabel;


    public void setDatabaseErrorMessage(String databaseErrorMessage) {
        errorMessageLabel.setText(databaseErrorMessage);
    }

    @FXML
    private void onLoginBtnClick(ActionEvent actionEvent) {
        if(checkFieldsFilled()){
            String username = usernameTf.getText();
            String password = passwordTf.getText();

            try {
                if (DatabaseUtility.checkUsernamePw(username, password)) {
                    System.out.println("Login successfull");
                    moveToMainPage();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            //alert.setHeaderText(header);
            alert.setContentText("Pls Fill in all input fields");
            alert.show();
        }

    }

    private void moveToMainPage() {
        Stage stage = getCurrentStage();

        FXMLLoader fxmlLoader = new FXMLLoader(LoginDatabaseApplication.class.getResource("main-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Main Page");
        stage.setScene(scene);
        stage.show();

    }

    private Stage getCurrentStage() {
        return (Stage) usernameTf.getScene().getWindow();
    }

    private boolean checkFieldsFilled() {
        if(usernameTf.getText() == null || passwordTf.getText() == null){
            return false;
        }
        if(usernameTf.getText().isBlank() || (passwordTf.getText().isBlank()))
        {
            return false;
        }
        return true;
    }

    @FXML
    private void onSignUpBtnCkick(ActionEvent actionEvent) {
        Stage stage = getCurrentStage();

        FXMLLoader fxmlLoader = new FXMLLoader(LoginDatabaseApplication.class.getResource("signup-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Sign up!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameTf.setText(null);
        passwordTf.setText(null);
    }


}