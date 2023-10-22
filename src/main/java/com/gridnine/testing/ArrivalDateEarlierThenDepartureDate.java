package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * results of segments with arrival date earlier than departure date
 */
public class ArrivalDateEarlierThenDepartureDate implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Flights with date of arrival earlier then date of departure:");
        return flightList
                .stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
