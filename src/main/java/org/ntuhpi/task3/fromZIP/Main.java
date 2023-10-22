package org.ntuhpi.task3.fromZIP;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("academic_group.zip"))){
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                System.out.println("File: " + entry.getName());
                BufferedReader reader = new BufferedReader(new InputStreamReader(zipInputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

