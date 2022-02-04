package at.muradundmurad.app.coders318.fphotolibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PhotoLibraryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PhotoLibraryApplication.class.getResource("photo-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Photo Library");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}