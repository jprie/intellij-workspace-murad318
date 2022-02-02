module at.muradundmurad.app.coders318.ehelloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.muradundmurad.app.coders318.ehelloworld to javafx.fxml;
    exports at.muradundmurad.app.coders318.ehelloworld;
}