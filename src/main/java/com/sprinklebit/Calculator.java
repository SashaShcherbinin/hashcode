package com.sprinklebit;

import com.sprinklebit.output.Info;
import com.sprinklebit.output.Result;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
//    public static Result calculate(List<Library> libs, int days) {
//        Library bestLib = getBestLib(libs);
//
//        int daysLeft = days - bestLib.signUpInDays;
//        libs.remove(bestLib);
//        List<Integer> bookIds = new ArrayList<>();
//        addBooks(bookIds, bestLib);
//        List<Info> outputLibs = new ArrayList<>();
//        Info info = new Info(bestLib.id, 0, bookIds);
//        info.bookCount = bookIds.size();
//        outputLibs.add(info);
//        return new Result(outputLibs.size(), outputLibs);
//    }
//
//    private static void addBooks(List<Integer> bookIds, Library bestLib) {
//        for (int i=0; i<bestLib.booksPerDay; i++)
//        bookIds.add(bestLib.booksIds[i]);
//    }
//
//    private static Library getBestLib(List<Library> libs) {
//        float bestKpd = 0;
//        Library bestLib = null;
//        for (int i = 0; i < libs.size(); i++) {
//            Library lib = libs.get(i);
//            if (lib.kpd > bestKpd) {
//                bestLib = libs.get(i);
//                bestKpd = bestLib.kpd;
//            }
//        }
//        return bestLib;
//    }
}
