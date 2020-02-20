package com.sprinklebit;

import com.sprinklebit.output.Info;
import com.sprinklebit.output.Result;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AlexCalculation {

    public static Result cacluclate(List<Library> libs, int librariesCount, int maxDays) {
        Set<Integer> usedBooks = new LinkedHashSet<>();
        int innerMaxDays = maxDays;

        while (innerMaxDays >= 0) {
            Library bestLibrary = getBestLibrary(libs, usedBooks, innerMaxDays);
            libs.remove(bestLibrary);
            innerMaxDays -= bestLibrary.signUpInDays;
            usedBooks.addAll(getUsedBooks(bestLibrary, innerMaxDays));
            if (libs.size() == 0) {
                break;
            }
        }

        return new Result(0, new ArrayList<Info>());
    }

    private static Library getBestLibrary(List<Library> libs,
                                          Set<Integer> usedBooks,
                                          int innerMaxDays) {
        Library bestLibrary = libs.get(0);
        for(Library library : libs) {
            library.updateScore(innerMaxDays, usedBooks);
            if (bestLibrary.baseScore > library.baseScore) {
                bestLibrary = library;
            }
        }

        return bestLibrary;
    }

    static Set<Integer> getUsedBooks(Library library, int maxDays) {

    }
}
