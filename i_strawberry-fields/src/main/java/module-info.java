module at.muradundmurad.appdevs.coders318.i_strawberryfields {
    requires javafx.controls;
    requires javafx.fxml;

      // FIXME: Problem ist, dass das Package keine Klassen mehr enthält
        // FIXME: UND die RunConfiguration noch auf das alte package zeigt.
    // Deswegen: RunConfiguration löschen und neu erstellen
//    opens at.muradundmurad.appdevs.coders318.i_strawberryfields to javafx.fxml;
    exports at.muradundmurad.appdevs.coders318.i_strawberryfields.app;
    opens at.muradundmurad.appdevs.coders318.i_strawberryfields.app to javafx.fxml;
    exports at.muradundmurad.appdevs.coders318.i_strawberryfields.controller;
    opens at.muradundmurad.appdevs.coders318.i_strawberryfields.controller to javafx.fxml;
    exports at.muradundmurad.appdevs.coders318.i_strawberryfields.model;
    opens at.muradundmurad.appdevs.coders318.i_strawberryfields.model to javafx.fxml;
}