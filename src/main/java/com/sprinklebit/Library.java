package com.sprinklebit;

import java.util.ArrayList;
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
        leftBooks = AlexCalculation.getUsedBooks(this, maxDays);

        int libraryScore = 0;
        for (int booksId : leftBooks) {
            libraryScore += Main.scoreList[booksId];
        }

        kpd = baseScore / (((float)booksCount / (float)booksPerDay) + signUpInDays);
    }

    private Set<Integer> removeUsedBooks(Set<Integer> usedBooks) {
        // todo remove used books from booksIds
    }


}
