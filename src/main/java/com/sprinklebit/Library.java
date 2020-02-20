package com.sprinklebit;

import java.util.LinkedHashSet;
import java.util.Set;

public class Library {
    public int id;
    public int booksCount = 0;
    public int signUpInDays = 0;
    public int booksPerDay = 0;
    public Integer[] booksIds;

    public float baseScore = 0;

    public Library(int id,
                   int booksCount,
                   int signUpInDays,
                   int booksPerDay,
                   Integer[] booksIds) {
        this.id = id;
        this.booksCount = booksCount;
        this.signUpInDays = signUpInDays;
        this.booksPerDay = booksPerDay;
        this.booksIds = booksIds;
    }

    void updateScore(int maxDays, Set<Integer> usedBooks) {
        Set<Integer> leftBooks = removeUsedBooks(usedBooks);
        booksIds = leftBooks.toArray(new Integer[leftBooks.size()]);
        leftBooks = AlexCalculation.getUsedBooks(this, maxDays);
        int libraryScore = 0;
        for (int booksId : leftBooks) {
            libraryScore += Main.scoreList[booksId];
        }

        baseScore = libraryScore;
    }

    private Set<Integer> removeUsedBooks(Set<Integer> usedBooks) {
        Set<Integer> booksSet = new LinkedHashSet<>();
        for (int i = 0; i < this.booksIds.length; i++) {
            if (usedBooks.contains(this.booksIds[i])) {
                continue;
            }
            booksSet.add(this.booksIds[i]);
        }

        return booksSet;
    }
}
