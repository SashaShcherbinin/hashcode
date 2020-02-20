package com.sprinklebit;

public class Library {
    private int booksCount = 0;
    private int signProcess = 0;
    private int booksPerDay = 0;
    private int[] booksIds;

    public Library(int booksCount, int signProcess, int booksPerDay, int[] booksIds) {
        this.booksCount = booksCount;
        this.signProcess = signProcess;
        this.booksPerDay = booksPerDay;
        this.booksIds = booksIds;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

    public int getSignProcess() {
        return signProcess;
    }

    public void setSignProcess(int signProcess) {
        this.signProcess = signProcess;
    }

    public int getBooksPerDay() {
        return booksPerDay;
    }

    public void setBooksPerDay(int booksPerDay) {
        this.booksPerDay = booksPerDay;
    }

    public int[] getBooksIds() {
        return booksIds;
    }

    public void setBooksIds(int[] booksIds) {
        this.booksIds = booksIds;
    }
}
