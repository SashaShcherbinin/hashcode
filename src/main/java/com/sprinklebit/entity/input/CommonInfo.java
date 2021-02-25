package com.sprinklebit.entity.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonInfo {
    public int simulationLast;
    public int intersections;
    public int streets;
    public int vehicles;
    public int bonus;
    public Map<String, Street> streetMap = new HashMap<>();
    public List<Path> paths = new ArrayList<>();

    public CommonInfo(int simulationLast, int intersections, int streets, int vehicles, int bonus) {
        this.simulationLast = simulationLast;
        this.intersections = intersections;
        this.streets = streets;
        this.vehicles = vehicles;
        this.bonus = bonus;
    }
}
