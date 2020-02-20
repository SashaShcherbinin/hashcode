package com.sprinklebit;

import com.sprinklebit.output.Info;
import com.sprinklebit.output.Result;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static Result calculate(List<Library> libs) {
        Library bestLib = getBestLib(libs);

        int daysLeft = bestLib.signUpInDays;


        List<Info> outputLibs = new ArrayList<>();
        Result result = new Result(outputLibs.size(), outputLibs);
        return result;
    }

    private static Library getBestLib(List<Library> libs) {
        float bestKpd = 0;
        Library bestLib = null;
        for (int i = 0; i < libs.size(); i++) {
            Library lib = libs.get(i);
            if (lib.kpd > bestKpd) {
                bestLib = libs.get(i);
                bestKpd = bestLib.kpd;
            }
        }
        return bestLib;
    }
}
