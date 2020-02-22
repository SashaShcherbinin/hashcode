package com.sprinklebit.entity.output;

import java.util.List;

public class Result {

    public int libraryCount = 0;
    public List<Info> infoList;

    public Result(int libraryCount , List<Info> infoList) {
        this.libraryCount = libraryCount;
        this.infoList = infoList;
    }
}
