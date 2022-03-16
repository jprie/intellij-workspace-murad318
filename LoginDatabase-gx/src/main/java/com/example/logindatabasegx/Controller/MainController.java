package com.example.logindatabasegx.Controller;

import com.example.logindatabasegx.DatabaseUtility;
import com.example.logindatabasegx.LoginDatabaseApplication;
import com.example.logindatabasegx.Model.Order;
import com.example.logindatabasegx.Model.OrderModel;
import com.example.logindatabasegx.Model.UserModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Text welcomeText;
    @FXML
    private TableColumn<OrderModel, String> productColumn;
    @FXML
    private TableView<Order> orderTableView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("Welcome user " + UserModel.fName + " " + UserModel.lName + "!");

        DatabaseUtility.readOrders();
        //initTable();

    }
    private void intiTable(ObservableList<Order> list) {
        orderTableView.setItems(list);

        //productColumn.setCellValueFactory(SimpleStringProperty);
    }

    @FXML
    private void onLogoutBtnClick(ActionEvent actionEvent) {
        UserModel.userid = null;
        UserModel.username = null;
        UserModel.fName = null;
        UserModel.lName = null;
        moveToLogin();
    }

    private void moveToLogin() {
        Stage stage = getCurrentStage();

        FXMLLoader fxmlLoader = new FXMLLoader(LoginDatabaseApplication.class.getResource("login-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    private Stage getCurrentStage() {
        return (Stage) welcomeText.getScene().getWindow();
    }
}
