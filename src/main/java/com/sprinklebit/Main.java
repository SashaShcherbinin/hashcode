package com.sprinklebit;

import com.sprinklebit.output.Info;
import com.sprinklebit.output.Result;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] scoreList;

    public static void main(String[] args) {
        System.out.println("test");

        calculation("a_example.txt");
        calculation("b_read_on.txt");
        calculation("a_example.txt");
        calculation("a_example.txt");
    }

    private static void calculation(String fileName) {
        List<List<String>> s = ReaderWriter.read(fileName);
        int bookCount = Integer.parseInt(s.get(0).get(0));
        int librariesCount = Integer.parseInt(s.get(0).get(1));
        int maxDays = Integer.parseInt(s.get(0).get(2));

        scoreList = new int[bookCount];
        List<String> booksScore = s.get(1);
        for (int i = 0; i < booksScore.size(); i++) {
            scoreList[i] = Integer.parseInt(booksScore.get(i));
        }

        List<Library> libs = createInput(s);

        Result calculate = AlexCalculation.cacluclate(libs, librariesCount, maxDays);

        String stringResult = createOutPutString(calculate);

        try {
            ReaderWriter.write(stringResult,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createOutPutString(Result calculate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(calculate.libraryCount);
        stringBuilder.append("\n");
        for(Info info : calculate.infoList) {
            stringBuilder.append(info.libraryId);
            stringBuilder.append(" ");
            stringBuilder.append(info.bookCount);
            stringBuilder.append("\n");
            for(int bookId: info.bookIds) {
                stringBuilder.append(bookId);
                stringBuilder.append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static List<Library> createInput(List<List<String>> s) {
        List<Library> libs = new ArrayList<>();
        for (int i = 2; i < s.size(); i = i + 2) {
            int booksCount = Integer.parseInt(s.get(i).get(0));
            int signProcess = Integer.parseInt(s.get(i).get(1));
            int booksPerDay = Integer.parseInt(s.get(i).get(2));
            int id = i / 2;
            int[] booksList = new int[booksCount];
            for (int j = 0; j < s.get(i + 1).size(); j++) {
                booksList[j] = Integer.parseInt(s.get(i + 1).get(j));
            }

            Library lib = new Library(id, booksCount, signProcess, booksPerDay, booksList);
            libs.add(lib);
        }
        return libs;
    }

    private static Result calculate(List<Library> libs) {



        return new Result(0, new ArrayList<Info>());

    }
}
