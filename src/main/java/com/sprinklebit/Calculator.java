package com.sprinklebit;

import com.sprinklebit.entity.input.Library;

import java.util.*;

public class Calculator {

    public List<Library> calculate(List<Library> libs, int maxDays) {
        Set<Integer> usedBooks = new LinkedHashSet<>();
        List<Library> libraryOrder = new ArrayList<>();

        while (maxDays >= 0) {
            Library bestLibrary = getBestLibrary(libs, usedBooks, maxDays);
            maxDays -= bestLibrary.signUpInDays;
            if (maxDays <= 0) {
                break;
            }
            libs.remove(bestLibrary);
            libraryOrder.add(bestLibrary);
            usedBooks.addAll(bestLibrary.booksIds);
            if (libs.size() == 0) {
                break;
            }
        }

        return libraryOrder;
    }

    private Library getBestLibrary(List<Library> libs,
                                   Set<Integer> usedBooks,
                                   int innerMaxDays) {
        Library bestLibrary = libs.get(0);
        for (Library library : libs) {
            library.updateScore(innerMaxDays, usedBooks);
            if (library.baseScore > bestLibrary.baseScore) {
                bestLibrary = library;
            }
        }

        return bestLibrary;
    }


}
