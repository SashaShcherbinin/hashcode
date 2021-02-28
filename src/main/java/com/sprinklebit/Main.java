package com.sprinklebit;

import com.sprinklebit.entity.input.*;
import com.sprinklebit.entity.output.Result;
import com.sprinklebit.entity.output.StreetTimer;
import com.sprinklebit.entity.output.TrafficLight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static int[] scoreList;

    public static void main(String[] args) throws IOException {
        process("a.txt");
    }

    public static void process(String fileName) throws IOException {
        CommonInfo commonInfo = ReaderWriter.read(fileName);
        Result result = calculate(commonInfo);
        writeInFile(result, fileName);
    }

    private static void writeInFile(Result result, String fileName) throws IOException {
        StringBuilder resultStr = new StringBuilder(result.trafficLightNumber + "\n");
        result.infoList.forEach(trafficLight -> {
            resultStr.append(trafficLight.intersectionId + "\n");
            resultStr.append(trafficLight.incomingStringCount + "\n");
            trafficLight.streetTimers.forEach(streetTimer -> {
                resultStr.append(streetTimer.streetName);
                resultStr.append(" ");
                resultStr.append(streetTimer.timePerCycle + "\n");
            });
        });

        ReaderWriter.write(resultStr.toString(), fileName);
    }

    private static Result calculate(CommonInfo commonInfo) {
        Map<Integer, Intersection> intersectionsMap = new HashMap<>();
        for (Path path : commonInfo.paths) {
            int pathSize = path.streets.size() - 1;
            for (int i=0; i<pathSize; i++) {
                Street street = path.streets.get(i);
                Intersection intersection = new Intersection();
                if (intersectionsMap.containsKey(street.end)) {
                    intersection = intersectionsMap.get(street.end);
                    if (intersection.incomingStreets.containsKey(street.name)) {
                        intersection.incomingStreets.put(street.name, intersection.incomingStreets.get(street.name) + 1);
                    } else {
                        intersection.incomingStreets.put(street.name, 1);
                    }
                } else {
                    intersection.incomingStreets.put(street.name, 1);
                    intersectionsMap.put(street.end, intersection);
                }
                intersection.total++;
            }
        }

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (Map.Entry<Integer, Intersection> entry : intersectionsMap.entrySet()) {
            int intersectionId = entry.getKey();
            int incomingStringCount = entry.getValue().incomingStreets.size();
            List<StreetTimer> streetTimers = new ArrayList<>();
            for (Map.Entry<String, Integer> en : entry.getValue().incomingStreets.entrySet()) {
                int timePerCycle = en.getValue() / entry.getValue().total;
                if (timePerCycle == 0) {
                    timePerCycle = 1;
                }
                StreetTimer streetTimer = new StreetTimer(en.getKey(), timePerCycle);
                streetTimers.add(streetTimer);
            }
            TrafficLight trafficLight = new TrafficLight(intersectionId, incomingStringCount, streetTimers);
            trafficLights.add(trafficLight);
        }

        return new Result(trafficLights.size(), trafficLights);
    }
}
