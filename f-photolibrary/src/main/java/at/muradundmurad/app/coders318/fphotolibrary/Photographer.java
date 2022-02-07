package at.muradundmurad.app.coders318.fphotolibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Photographer {

    private String firstName;
    private String lastName;
    private List<Photo> photos = new ArrayList<>();

    public Photographer(String firstName, String lastName, List<Photo> photos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photos = photos;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photographer that = (Photographer) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(photos, that.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, photos);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
