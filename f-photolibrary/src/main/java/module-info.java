module at.muradundmurad.app.coders318.fphotolibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;

    requires org.kordamp.bootstrapfx.core;

    opens at.muradundmurad.app.coders318.fphotolibrary to javafx.fxml;
    exports at.muradundmurad.app.coders318.fphotolibrary;
}