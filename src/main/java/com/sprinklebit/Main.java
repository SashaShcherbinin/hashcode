package com.sprinklebit;

import com.sprinklebit.entity.input.CommonInfo;
import com.sprinklebit.entity.output.Result;

import java.io.IOException;

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

}
