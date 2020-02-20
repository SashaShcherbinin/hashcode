package com.sprinklebit.output;

import java.util.List;

public class Result {

    public int libraryCount = 0;
    public List<Info> infoList;

    Result(List<Info> infoList) {
        this.infoList = infoList;
    }
}
