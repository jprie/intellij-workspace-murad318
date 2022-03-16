package com.example.logindatabasegx.Controller;

import com.example.logindatabasegx.DatabaseUtility;
import com.example.logindatabasegx.LoginDatabaseApplication;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {
    @FXML
    private TextField usernameTf;

    @FXML
    private PasswordField pwd2Tf;
    @FXML
    private TextField lNameTf;
    @FXML
    private TextField emailTf;
    @FXML
    private TextField pwd1Tf;
    @FXML
    private TextField fNameTf;
    @FXML
    private ChoiceBox genderCb;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> genderList = FXCollections.observableArrayList();

        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Diversed");
        genderList.add("No-Binar");
        //Liste der ChoiceBox hinzufügen
        genderCb.setItems(genderList);

        usernameTf.setText(null);
        fNameTf.setText(null);
        lNameTf.setText(null);
        emailTf.setText(null);
        pwd1Tf.setText(null);
        pwd2Tf.setText(null);
    }

    @FXML
    private void onCancelBtnClick(ActionEvent actionEvent) {
        moveToLoginPage();
    }

    @FXML
    private void onSubmitBtnClick(ActionEvent actionEvent) {
        if(checkFields()){
            User user = new User(0, usernameTf.getText(), fNameTf.getText(), lNameTf.getText(), emailTf.getText(),
                    pwd1Tf.getText(), genderCb.getSelectionModel().getSelectedItem().toString());
            if(DatabaseUtility.insertUser(user)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                //alert.setHeaderText(header);
                alert.setContentText(usernameTf + " was successfully created");
                alert.show();
                moveToLoginPage();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            //alert.setHeaderText(header);
            alert.setContentText("Pls Fill in all input fields");
            alert.show();
        }
    }

    private void moveToLoginPage() {
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

    private boolean checkFields() {
        if( usernameTf.getText() == null || fNameTf.getText() == null  || lNameTf.getText() == null
                || emailTf.getText() == null || pwd1Tf.getText() == null || pwd2Tf.getText() == null){

            return false;
        }
        if (usernameTf.getText().isBlank() || fNameTf.getText().isBlank() || lNameTf.getText().isBlank()
                || pwd1Tf.getText().isBlank() || pwd2Tf.getText().isBlank() || emailTf.getText().isBlank()){
            return false;
        }
        return true;
    }

    private Stage getCurrentStage() {
        return (Stage) usernameTf.getScene().getWindow();
    }

}
