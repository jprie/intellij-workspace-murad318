package com.example.logindatabasegx;

import com.example.logindatabasegx.Controller.LoginController;
import com.example.logindatabasegx.Controller.SignupController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LoginDatabaseApplication extends Application {

    private String databaseErrorMessage;

    @Override
    public void init() throws Exception {
        super.init();
        try {
            DatabaseUtility.connectDatabase();
        } catch (SQLException e) {
            databaseErrorMessage = e.getMessage();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginDatabaseApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        LoginController controller = fxmlLoader.getController();
        controller.setDatabaseErrorMessage(databaseErrorMessage);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DatabaseUtility.closeConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}