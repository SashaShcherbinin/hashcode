package com.sprinklebit;

import com.sprinklebit.output.Info;
import com.sprinklebit.output.Result;

import java.util.*;

public class AlexCalculation {

    public static Result cacluclate(List<Library> libs, int librariesCount, int maxDays) {
        Set<Integer> usedBooks = new LinkedHashSet<>();
        List<Library> usedLibraries = new ArrayList<>();

        while (maxDays >= 0) {
            Library bestLibrary = getBestLibrary(libs, usedBooks, maxDays);
            libs.remove(bestLibrary);
            usedLibraries.add(bestLibrary);
            maxDays -= bestLibrary.signUpInDays;
            usedBooks.addAll(getUsedBooks(bestLibrary, maxDays));
            if (libs.size() == 0) {
                break;
            }
        }

        return mapResult(usedLibraries);
    }

    private static Result mapResult(List<Library> libraryList) {
        List<Info> infos = new ArrayList<>();
        for (int i = 0; i < libraryList.size(); i++) {
            List<Integer> ids = Arrays.asList(libraryList.get(i).booksIds);
            Info info = new Info(libraryList.get(i).id, libraryList.get(i).booksIds.length, ids);
            infos.add(info);
        }

        return new Result(infos.size(), infos);
    }

    private static Library getBestLibrary(List<Library> libs,
                                          Set<Integer> usedBooks,
                                          int innerMaxDays) {
        Library bestLibrary = libs.get(0);
        System.out.println(bestLibrary.id);
        for (Library library : libs) {
            library.updateScore(innerMaxDays, usedBooks);
            if (library.baseScore >= bestLibrary.baseScore) {
                bestLibrary = library;
            }
        }

        return bestLibrary;
    }

    static Set<Integer> getUsedBooks(Library library, int maxDays) {
        int maxBooks = maxDays * library.booksPerDay;
        HashSet<Integer> userBooks = new HashSet<>();
        for (int i = 0; i < maxBooks; i++) {
            int bestBookScore = 0;
            int bestBookId = 0;
            for (int bookId : library.booksIds) {
                int score = Main.scoreList[bookId];
                if (score > bestBookScore) {
                    bestBookScore = score;
                    bestBookId = bookId;
                }
            }
            userBooks.add(bestBookId);
        }

        return userBooks;
    }
}
