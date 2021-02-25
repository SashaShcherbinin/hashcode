package com.sprinklebit.entity.output;

import java.util.Set;

class TrafficLight {
    public int intersectionId;
    public int incomingStringCount;
    public Set<StreetTimer> streetTimers;

    public TrafficLight(int intersectionId, int incomingStringCount, Set<StreetTimer> streetTimers) {
        this.intersectionId = intersectionId;
        this.incomingStringCount = incomingStringCount;
        this.streetTimers = streetTimers;
    }
}
