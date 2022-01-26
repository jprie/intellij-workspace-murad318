package at.appdevs.basics;

import java.util.Objects;

// POJOs - plain old java object (java.lang.Object)
// Klasse erbt nur von java.lang.Object
public class Dog {

    private String name;
    private String barkSound;

    public Dog(String name, String barkSound) {
        this.name = name;
        this.barkSound = barkSound;
    }

    @Override
    public boolean equals(Object o) {

        // Frage: was tut das?
        // 1) Referenzvergleich zwischen this(dog) und o(equalsDog)
        if (this == o) {
            return true;
        }
        // 2) Ist Object o tatsächlich kein Dog
        if (!(o instanceof Dog)) {
            return false;
        }
        // 3) Wir wissen es ist ein Dog Objekt -> wir können Attribute vergleichen
        Dog dog = (Dog)o;
        return Objects.equals(name, dog.name) && Objects.equals(barkSound, dog.barkSound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, barkSound);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", barkSound='" + barkSound + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarkSound() {
        return barkSound;
    }

    public void setBarkSound(String barkSound) {
        this.barkSound = barkSound;
    }
}
