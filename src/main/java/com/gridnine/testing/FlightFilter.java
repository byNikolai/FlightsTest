package com.gridnine.testing;

import java.util.List;

public class FlightFilter {
    private List<Flight> flights;
    private Filter filter;

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public List<Flight> performFilter() {
        return filter.filter(flights);
    }
}
