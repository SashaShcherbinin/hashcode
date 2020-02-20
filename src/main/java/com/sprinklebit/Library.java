package com.sprinklebit;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Library {
    public int id;
    public int booksCount = 0;
    public int signUpInDays = 0;
    public int booksPerDay = 0;
    public int[] booksIds;

    public float baseScore = 0;

    public Library(int id,
                   int booksCount,
                   int signUpInDays,
                   int booksPerDay,
                   int[] booksIds) {
        this.id = id;
        this.booksCount = booksCount;
        this.signUpInDays = signUpInDays;
        this.booksPerDay = booksPerDay;
        this.booksIds = booksIds;
    }

    void updateScore(int maxDays, Set<Integer> usedBooks) {
        Set<Integer> leftBooks = removeUsedBooks(usedBooks);


        baseScore = 0;
        for (int booksId : booksIds) {
            baseScore += Main.scoreList[booksId];
        }

        kpd = baseScore / (((float)booksCount / (float)booksPerDay) + signUpInDays);
    }

    private Set<Integer> removeUsedBooks(Set<Integer> usedBooks) {
        Set<Integer> booksSet = new LinkedHashSet<>();
        for (int i=0; i<this.booksIds.length; i++) {
            if (usedBooks.contains(this.booksIds[i])) {
                continue;
            }
            booksSet.add(this.booksIds[i]);
        }

        return booksSet;
    }
}
