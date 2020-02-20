package com.sprinklebit.output;

import java.util.List;

public class Info {
    public int libraryId = 0;
    public int bookCount = 0;
    public List<Integer> bookIds;

    Info(int libraryId, int bookCount, List<Integer> bookIds) {
        this.libraryId = libraryId;
        this.bookCount = bookCount;
        this.bookIds = bookIds;
    }
}
