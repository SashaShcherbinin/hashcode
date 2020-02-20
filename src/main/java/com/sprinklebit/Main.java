package com.sprinklebit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("test");
//        try {
//            ReaderWriter.write("fffaaa", "result");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        List<List<String>> s = ReaderWriter.read("a_example.txt");
        int bookCount = Integer.parseInt(s.get(0).get(0));
        int librariesCount = Integer.parseInt(s.get(0).get(1));
        int days = Integer.parseInt(s.get(0).get(2));

        int[] scoreList = new int[bookCount];
        List<String> booksScore = s.get(1);
        for (int i = 0; i < booksScore.size(); i++) {
            scoreList[i] = Integer.parseInt(booksScore.get(i));
        }

        List<Library> libs = new ArrayList<>();
        for (int i = 2; i < s.size(); i = i + 2) {
            int booksCount = Integer.parseInt(s.get(i).get(0));
            int signProcess = Integer.parseInt(s.get(i).get(1));
            int booksPerDay = Integer.parseInt(s.get(i).get(2));
            int[] booksList = new int[booksCount];
            for (int j = 0; j < s.get(i + 1).size(); j++) {
                booksList[j] = Integer.parseInt(s.get(i + 1).get(j));
            }
            Library lib = new Library(booksCount, signProcess, booksPerDay, booksList);
            libs.add(lib);
        }

        int a = 0;
    }
}
