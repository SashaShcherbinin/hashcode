package com.sprinklebit;

import java.util.List;
import java.util.Set;

public class Library {
    private int id;
    private int booksCount = 0;
    private int signUpInDays = 0;
    private int booksPerDay = 0;
    private int[] booksIds;

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

        baseScore = 0;
        for (int booksId : booksIds) {
            baseScore += Main.scoreList[booksId];
        }

        kpd = baseScore / (((float)booksCount / (float)booksPerDay) + signUpInDays);
    }


}
