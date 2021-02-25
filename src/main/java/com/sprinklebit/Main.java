package com.sprinklebit;

import com.sprinklebit.entity.input.CommonInfo;
import com.sprinklebit.entity.input.Library;

import java.util.List;

public class Main {

    public static int[] scoreList;

    public static void main(String[] args) {
        List<Library> objects = readFile("a_example.txt");
        ReaderWriter rw = new ReaderWriter();
        CommonInfo c = ReaderWriter.read("a.txt");
        String resultStr = calculate(objects);
        writeInFile("result_a_example.txt");
    }

    private static void writeInFile(String resultStr) {

    }

    private static String calculate(List<Library> objects) {
        return null;
    }

    private static List<Library> readFile(String fileName) {
        return null;
    }

}
