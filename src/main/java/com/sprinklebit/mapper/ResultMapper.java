package com.sprinklebit.mapper;

import com.sprinklebit.entity.input.Library;
import com.sprinklebit.entity.output.Info;
import com.sprinklebit.entity.output.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultMapper {

    public Result map(List<Library> libraryList) {
        List<Info> infoList = new ArrayList<>();
        for (Library library : libraryList) {
            Info info = new Info(library.id, library.booksIds.size(), library.booksIds);
            infoList.add(info);
        }

        return new Result(infoList.size(), infoList);
    }
}
