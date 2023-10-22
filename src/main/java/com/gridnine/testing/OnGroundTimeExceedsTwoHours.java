package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * total time spent on the ground exceeds two hours
 */
public class OnGroundTimeExceedsTwoHours implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        System.out.println("Flights with total time spent on the ground exceeds two hours:");
        return flightList
                .stream()
                .filter(flight -> flight.getSegments().size() > 1)
                .filter(flight -> onGroundWaiting(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private static boolean onGroundWaiting(List<Segment> segments) {
        long totalTime = 0;
        for (int i = 1; i < segments.size(); i++) {
            totalTime = totalTime + Duration.between(segments.get(i - 1).getArrivalDate(),
                    segments.get(i).getDepartureDate()).toHours();
        }
        return totalTime > onGround;
    }

}
