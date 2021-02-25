package com.sprinklebit.entity.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonInfo {
    public int simulationLast;
    public int intersectionNumbers;
    public int streetNumber;
    public int carNumber;
    public int bonus;
    public Map<String, Street> streetMap = new HashMap<>();
    public List<Path> paths = new ArrayList<>();

    public CommonInfo(int simulationLast, int intersectionNumbers, int streetNumber, int carNumber, int bonus) {
        this.simulationLast = simulationLast;
        this.intersectionNumbers = intersectionNumbers;
        this.streetNumber = streetNumber;
        this.carNumber = carNumber;
        this.bonus = bonus;
    }
}
