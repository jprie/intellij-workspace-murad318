package at.muradundmurad.app.coders318.fphotolibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhotoLibrary {

    public static final ObservableList<Photo> photos = FXCollections.observableArrayList();

    // Erstellt eine observableArrayList mit den Elementen der List.of
    public static final ObservableList<Photographer> photographers =
            FXCollections.observableArrayList(List.of(
            new Photographer("Johannes", "Priebsch", new ArrayList<>())));

}
