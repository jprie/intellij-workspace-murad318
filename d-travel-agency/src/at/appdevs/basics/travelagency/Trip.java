package at.appdevs.basics.travelagency;

import java.math.BigDecimal;
import java.util.Objects;

public class Trip {

    private static int nextID = 1;

    private long id;
    private String name;
    private BigDecimal price;
    private String destinaton;

    public Trip(String name, BigDecimal price, String destinaton) {

        this.id = nextID++;
        this.name = name;
        this.price = price;
        this.destinaton = destinaton;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id && Objects.equals(name, trip.name) && Objects.equals(price, trip.price) && Objects.equals(destinaton, trip.destinaton);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, destinaton);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDestinaton() {
        return destinaton;
    }

    public void setDestinaton(String destinaton) {
        this.destinaton = destinaton;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", destinaton='" + destinaton + '\'' +
                '}';
    }
}
