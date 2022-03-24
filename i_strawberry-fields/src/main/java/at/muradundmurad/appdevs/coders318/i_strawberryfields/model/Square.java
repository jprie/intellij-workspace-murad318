package at.muradundmurad.appdevs.coders318.i_strawberryfields.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Square {

    private ObjectProperty<String> item = new SimpleObjectProperty<>();

    // String wird in Property gepackt
    public Square(String item) {
        setItem(item);
    }

    public String getItem() {
        return item.get();
    }

    // Property-Getter
    public ObjectProperty<String> itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }
}
