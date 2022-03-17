package at.muradundmurad.appdevs.coders318.hstrawberryfields.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Square {

    private StringProperty item = new SimpleStringProperty();

    public Square(String item) {
        setItem(item);
    }

    public String getItem() {
        return item.get();
    }

    public StringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }
}
