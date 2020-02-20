package com.sprinklebit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReaderWriter {

    private static String PATH_IN = "resources/in/";
    private static String PATH_OUT = "resources/out/";

    public static List<String> read(String fileName) {
        File file = new File(PATH_IN + fileName);
        List<String> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                list.add(i);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            list = Collections.emptyList();
        }
        return list;
    }


    public static void write(String result, String fileName) throws IOException {
        PrintWriter writer = null;

        File file = new File(PATH_OUT + fileName);

        if (!file.getParentFile().exists()) {
            if (file.getParentFile().mkdir()) {
                file.createNewFile();
            } else {
                throw new IOException("Failed to create directory " + file.getParent());
            }
        } else {
            file.createNewFile();
        }

        try {
            writer = new PrintWriter(file, "UTF-8");
            writer.println(result);
            writer.close();
        } catch (
                UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

}
