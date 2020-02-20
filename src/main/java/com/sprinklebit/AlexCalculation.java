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
        List<Library> usedLibraries = new ArrayList<>();

        while (innerMaxDays >= 0) {
            Library bestLibrary = getBestLibrary(libs, usedBooks, innerMaxDays);
            libs.remove(bestLibrary);
            usedLibraries.add(bestLibrary);
            innerMaxDays -= bestLibrary.signUpInDays;
            usedBooks.addAll(getUsedBooks(bestLibrary, innerMaxDays));
            if (libs.size() == 0) {
                break;
            }
        }



        return new Result(0, new ArrayList<Info>());
    }

    private static Result mapResult(List<Library> libraryList) {
        // todo Tania
    }

    private static Library getBestLibrary(List<Library> libs,
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

    static Set<Integer> getUsedBooks(Library library, int maxDays) {
        Set<Integer> result = null;
        int bestScore = 0;
        int[] leastScore = Main.scoreList.clone();

        int count = 0;
        int bestScoreId = getIndexOfLargest(leastScore);

        while (count < library.booksIds.length && maxDays > 0) {
            result.add(library.booksIds[bestScoreId]);
            count++;
            maxDays--;
            leastScore = removeTheElement(leastScore, bestScore);
            bestScoreId = getIndexOfLargest(leastScore);
        }
        return result;
    }

    public static int getIndexOfLargest(int[] array) {
        if (array == null || array.length == 0) return -1;

        int largest = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largest]) largest = i;
        }
        return largest;
    }

    public static int[] removeTheElement(int[] arr, int index) {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }
}
