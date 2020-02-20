package com.sprinklebit;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public int booksCount = 0;
    public int signUpInDays = 0;
    public int booksPerDay = 0;
    public int[] booksIds;

    public int baseScore = 0;
    public float kpd = 0f;

    private List<Integer> usedBooks = new ArrayList<>();

    public Library(int booksCount,
                   int signUpInDays,
                   int booksPerDay,
                   int[] booksIds) {
        this.booksCount = booksCount;
        this.signUpInDays = signUpInDays;
        this.booksPerDay = booksPerDay;
        this.booksIds = booksIds;

        baseScore = 0;
        for (int booksId : booksIds) {
            baseScore += Main.scoreList[booksId];
        }

        kpd = baseScore / (((float)booksCount / (float)booksPerDay) + signUpInDays);

    }



}
