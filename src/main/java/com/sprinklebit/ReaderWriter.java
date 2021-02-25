package com.sprinklebit;

import com.sprinklebit.entity.input.CommonInfo;
import com.sprinklebit.entity.input.Path;
import com.sprinklebit.entity.input.Street;

import java.io.*;
import java.util.*;

public class ReaderWriter {

    private static String PATH_IN = "resources/in/";
    private static String PATH_OUT = "resources/out/";

    public static CommonInfo read(String fileName) {
        File file = new File(PATH_IN + fileName);
        List<List<String>> list = new ArrayList<>();
        CommonInfo commonInfo = null;
        try {
            Scanner sc = new Scanner(file);
            String[] firstLine = sc.nextLine().split(" ");
            commonInfo = new CommonInfo(
                    Integer.parseInt(firstLine[0]),
                    Integer.parseInt(firstLine[1]),
                    Integer.parseInt(firstLine[2]),
                    Integer.parseInt(firstLine[3]),
                    Integer.parseInt(firstLine[4]));
            int i = 0;
            while (i < commonInfo.streets) {
                String[] s = sc.nextLine().split(" ");
                Street street = new Street(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2], Integer.parseInt(s[3]));
                commonInfo.streetMap.put(street.name, street);
                i++;
            }
            i = 0;
            while (i < commonInfo.vehicles) {
                String[] s = sc.nextLine().split(" ");
                Path path = new Path();
                int pathQty = Integer.parseInt(s[0]);
                int j = 1;
                while (j < pathQty) {
                    String streetName = s[j];
                    path.streets.add(commonInfo.streetMap.get(streetName));
                    j++;
                }
                commonInfo.paths.add(path);
                i++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            list = Collections.emptyList();
        }
        return commonInfo;
    }

    public static List<List<String>> readNormal(String fileName) {
        File file = new File(PATH_IN + fileName);
        List<List<String>> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                list.add(Arrays.asList(i.split(" ")));
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
