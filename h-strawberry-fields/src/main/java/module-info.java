module at.muradundmurad.appdevs.coders318.hstrawberryfields {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.muradundmurad.appdevs.coders318.hstrawberryfields to javafx.fxml;
    exports at.muradundmurad.appdevs.coders318.hstrawberryfields;
    exports at.muradundmurad.appdevs.coders318.hstrawberryfields.controller;
    opens at.muradundmurad.appdevs.coders318.hstrawberryfields.controller to javafx.fxml;
}