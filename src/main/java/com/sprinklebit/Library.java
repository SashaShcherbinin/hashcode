package com.sprinklebit;

import java.util.List;

public class Library {
    public int id;
    public int booksCount = 0;
    public int signUpInDays = 0;
    public int booksPerDay = 0;
    public int[] booksIds;

    public int baseScore = 0;
    public float kpd = 0f;

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

        baseScore = 0;
        for (int booksId : booksIds) {
            baseScore += Main.scoreList[booksId];
        }
    }

    void updateScore(int maxDays, List<Integer> usedBooks) {
        kpd = baseScore / (((float)booksCount / (float)booksPerDay) + signUpInDays);
    }


}
