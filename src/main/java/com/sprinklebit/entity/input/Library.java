package com.sprinklebit.entity.input;

import com.sprinklebit.Main;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Library {
    public int id;
    public int booksCount = 0;
    public int signUpInDays = 0;
    public int booksPerDay = 0;
    public Set<Integer> booksIds = null;

    public float baseScore = 0;

    public Library(int id,
                   int booksCount,
                   int signUpInDays,
                   int booksPerDay,
                   Set<Integer> booksIds) {
        this.id = id;
        this.booksCount = booksCount;
        this.signUpInDays = signUpInDays;
        this.booksPerDay = booksPerDay;
        this.booksIds = booksIds;
    }

    public void updateScore(int maxDays, Set<Integer> usedBooks) {
        Set<Integer> leftBooks = removeUsedBooks(usedBooks);
        booksIds = getBestBooks(leftBooks, maxDays - signUpInDays);
        int libraryScore = 0;
        for (int booksId : booksIds) {
            libraryScore += Main.scoreList[booksId];
        }

        baseScore = libraryScore / (float) signUpInDays;
    }

    private Set<Integer> removeUsedBooks(Set<Integer> usedBooks) {
        Set<Integer> booksSet = new LinkedHashSet<>();
        for (Integer booksId : this.booksIds) {
            if (usedBooks.contains(booksId)) {
                continue;
            }
            booksSet.add(booksId);
        }

        return booksSet;
    }

    private Set<Integer> getBestBooks(Set<Integer> ids, int maxDays) {
        ids = new LinkedHashSet(ids);
        int maxBooks = maxDays * booksPerDay;
        HashSet<Integer> scannedBooks = new HashSet<>();
        for (int i = 0; i < maxBooks; i++) {
            int bestBookScore = 0;
            int bestBookId = -1;
            for (int bookId : ids) {
                int score = Main.scoreList[bookId];
                if (score >= bestBookScore) {
                    bestBookScore = score;
                    bestBookId = bookId;
                }
            }
            if (bestBookId >= 0 ) {
                scannedBooks.add(bestBookId);
                ids.remove(bestBookId);
            }
            if (ids.isEmpty()) {
                break;
            }
        }

        return scannedBooks;
    }

}
