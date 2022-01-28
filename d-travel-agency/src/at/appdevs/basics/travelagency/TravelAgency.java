package at.appdevs.basics.travelagency;

import java.util.ArrayList;
import java.util.Objects;

public class TravelAgency {

    // package-visibility
    protected String name;
    private ArrayList<Trip> trips;

    public TravelAgency(String name, ArrayList<Trip> trips) {
        this.name = name;
        this.trips = trips;
    }

    public boolean addTrip(Trip trip) {

        return trips.add(trip);
    }

    public Trip removeTrip(int index) {

        return trips.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelAgency that = (TravelAgency) o;
        return Objects.equals(name, that.name) && Objects.equals(trips, that.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, trips);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    @Override
    public String toString() {
        return "TravelAgency{" +
                "name='" + name + '\'' +
                ", trips=" + trips +
                '}';
    }
}

