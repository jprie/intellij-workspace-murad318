package at.muradundmurad.appdevs.coders318.hstrawberryfields;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StrawberryFieldsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StrawberryFieldsApplication.class.getResource(Constants.PATH_TO_GAME_VIEW_FXML));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Strawberry Fields");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}