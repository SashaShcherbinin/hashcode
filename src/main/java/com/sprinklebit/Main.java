package com.sprinklebit;

import com.sprinklebit.entity.input.CommonInfo;
import com.sprinklebit.entity.input.Library;
import com.sprinklebit.entity.output.Result;

import java.io.IOException;
import java.util.List;

public class Main {

    public static int[] scoreList;

    public static void main(String[] args) throws IOException {
        CommonInfo commonInfo = ReaderWriter.read("a.txt");
        Result result = calculate(commonInfo);
        writeInFile(result, "result_a_example.txt");
    }

    private static void writeInFile(Result result, String fileName) throws IOException {
        StringBuilder resultStr = new StringBuilder(result.trafficLightNumber + "");
        result.infoList.forEach(trafficLight -> {
            resultStr.append(trafficLight.intersectionId);
            resultStr.append(trafficLight.incomingStringCount);
            trafficLight.streetTimers.forEach(streetTimer -> {
                resultStr.append(streetTimer.streetName);
                resultStr.append(" ");
                resultStr.append(streetTimer.timePerCycle);
            });
        });

        ReaderWriter.write(resultStr.toString(), fileName);
    }

    private static Result calculate(CommonInfo commonInfo) {
        return null;
    }

    private static List<Library> readFile(String fileName) {
        return null;
    }

}
