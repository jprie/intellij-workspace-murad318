package at.appdevs.basics;

import java.util.Objects;

public class Fox {

    private String name;
    private int age;

    public Fox(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    TODO: Methoden equals und hashCode überschreiben (@Override)


    @Override
    public boolean equals(Object o) { // steckt hinter o ein new Fox() oder irgendetwas anderes?
        // 1) Identitätsvergleich von o mit this
        if (this == o) return true;
        // 2) ist o null? und wenn nein, sind die Klasse (Fox) und die des Object ungleich?
        if (o == null || getClass() != o.getClass()) return false;

        // 3) zu diesem Zeitpunkt ist sicher: this nicht ident wie o UND o ist ein Fox

        o.toString(); // weil toString ist Methode von Object
//        o.getName(); // o lässt uns  nur auf die Methoden in Object zugreifen

        // Deswegen braucht es den Cast (Fox). Dadurch bekomme ich eine Fox-Referenz
        // und mit der kann ich auf alle Fox-Methoden zugreifen
        Fox fox = (Fox) o;
        return Objects.equals(name, fox.getName()) && Objects.equals(age, fox.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
