package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class MockFlights {
    protected final Filter filterTest;
    protected final List<Flight> flights = new ArrayList<>();

    private static final LocalDateTime threeDaysFromNow = LocalDateTime.now().plusDays(3);
    private static final Segment segment1 = new Segment(threeDaysFromNow, threeDaysFromNow.plusHours(2));
    private static final Segment segment2 = new Segment(threeDaysFromNow.plusHours(3), threeDaysFromNow.plusHours(4));
    private static final Segment segment3 = new Segment(LocalDateTime.now().minusDays(3), LocalDateTime.now().minusDays(3).plusHours(2));
    private static final Segment segment4 = new Segment(threeDaysFromNow, threeDaysFromNow.minusHours(6));
    private static final Segment segment5 = new Segment(threeDaysFromNow.plusHours(6), threeDaysFromNow.plusHours(7));

    /**
     * A normal flight
     */
    protected static final Flight flight1 = new Flight(Arrays.asList(segment1, segment2));
    /**
     * A flight with up to current time departure
     */
    protected static final Flight flight2 = new Flight(Collections.singletonList(segment3));
    /**
     * A flight with earlier arrival date then departure date
     */
    protected static final Flight flight3 = new Flight(Collections.singletonList(segment4));
    /**
     * A flight with on ground time exceeds 2 hours
     */
    protected static final Flight flight4 = new Flight(Arrays.asList(segment1, segment2, segment5));

    protected MockFlights(Filter filterTest) {
        this.filterTest = filterTest;
    }
}
