package com.gridnine.testing;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilter flightFilter = new FlightFilter();
        flightFilter.setFlights(flights);
        System.out.println("All flights:");
        printFlightList(flights);

        flightFilter.setFilter(new UpToCurrentTimeDeparture());
        printFlightList(flightFilter.performFilter());


        flightFilter.setFilter(new ArrivalDateEarlierThenDepartureDate());
        printFlightList(flightFilter.performFilter());


        flightFilter.setFilter(new OnGroundTimeExceedsTwoHours());
        printFlightList(flightFilter.performFilter());
    }

    public static void printFlightList(List<Flight> list) {
        list.forEach(System.out::println);
        System.out.println("==================================================================");
    }

}
