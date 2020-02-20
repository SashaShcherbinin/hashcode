package com.sprinklebit;

public class Library {
    public int booksCount = 0;
    public int signUpInDays = 0;
    public int booksPerDay = 0;
    public int[] booksIds;

    public int baseScore = 0;

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

    }

}
