package com.sprinklebit.entity.output;

import java.util.Set;

public class Info {
    public int libraryId = 0;
    public int bookCount = 0;
    public Set<Integer> bookIds;

    public Info(int libraryId, int bookCount, Set<Integer> bookIds) {
        this.libraryId = libraryId;
        this.bookCount = bookCount;
        this.bookIds = bookIds;
    }
}
