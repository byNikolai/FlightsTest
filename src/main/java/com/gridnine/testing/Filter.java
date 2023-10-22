package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public interface Filter {
    LocalDateTime currentMoment = LocalDateTime.now();
    int onGround = 2;
    List<Flight> filter(List<Flight> flightList);
}
