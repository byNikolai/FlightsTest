package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

/**
 * aircraft departure up to the current point of time
 */
public class UpToCurrentTimeDeparture implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Flights with aircraft departure is up to the current point of time:");
        return flightList
                .stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .anyMatch(segment -> segment.getDepartureDate().isBefore(currentMoment))
                )
                .collect(Collectors.toList());
    }
}

