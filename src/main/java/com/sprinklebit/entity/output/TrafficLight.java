package com.sprinklebit.entity.output;

import java.util.List;

public class TrafficLight {
    public int intersectionId;
    public int incomingStringCount;
    public List<StreetTimer> streetTimers;

    public TrafficLight(int intersectionId, int incomingStringCount, List<StreetTimer> streetTimers) {
        this.intersectionId = intersectionId;
        this.incomingStringCount = incomingStringCount;
        this.streetTimers = streetTimers;
    }
}
