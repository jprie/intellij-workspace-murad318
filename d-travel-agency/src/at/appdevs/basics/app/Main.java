package at.appdevs.basics.app;

import at.appdevs.basics.travelagency.TravelAgency;
import at.appdevs.basics.travelagency.Trip;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Trip barcelona = new Trip(
                "Barcelona Trip",
                new BigDecimal("2000.99"),
                "Barlcelona, Spain");

        Trip paris = new Trip(
                "Paris Trip",
                new BigDecimal("2200.99"),
                "Paris, France");

        if (barcelona.equals(paris)) {
            System.out.println("Barcelona equals Paris");
        }


//        Trip[] tripArray = new Trip[] {barcelona, paris};

        ArrayList<Trip> trips = new ArrayList<>(List.of(barcelona, paris));

//        trips.add(barcelona);
//        trips.add(paris);

        TravelAgency agency = new TravelAgency("FineTravels", trips);

//        agency.name = "anders";

        agency.addTrip(new Trip(
                "USA",
                new BigDecimal("12000"),
                "New York, USA")
        );

        agency.removeTrip(1);

        System.out.println(agency);
    }
}
