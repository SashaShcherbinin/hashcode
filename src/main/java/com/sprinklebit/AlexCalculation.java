package com.sprinklebit;

import com.sprinklebit.output.Info;
import com.sprinklebit.output.Result;

import java.util.ArrayList;
import java.util.List;

public class AlexCalculation {

    public static Result cacluclate(List<Library> libs, int librariesCount, int maxDays) {
        List<Integer> usedBooks = new ArrayList();
        int innerMaxDays = maxDays;

        Library bestLibrary = getBestLibrary(libs, usedBooks, innerMaxDays);
        innerMaxDays -= bestLibrary.signUpInDays;

        return new Result(0, new ArrayList<Info>());
    }

    private static Library getBestLibrary(List<Library> libs,
                                          List<Integer> usedBooks,
                                          int innerMaxDays) {
        for(Library library : libs) {
            library.updateScore(innerMaxDays, usedBooks);
        }
    }

    List<Integer> getUsedBooks(Library library, int maxDays) {

    }
}
