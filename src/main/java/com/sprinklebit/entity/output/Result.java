package com.sprinklebit.entity.output;

import java.util.List;

public class Result {

    public int trafficLightNumber;
    public List<TrafficLight> infoList;

    public Result(int trafficLightNumber, List<TrafficLight> infoList) {
        this.trafficLightNumber = trafficLightNumber;
        this.infoList = infoList;
    }
}
