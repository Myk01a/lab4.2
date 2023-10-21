package org.ntuhpi.task1;

import java.io.IOException;

public class Lab4 {
    public static void main(String[] args) {
        Lecture[] lectures = {
                new Lecture("2023-10-21", "Java Basics", 30),
                new Lecture("2023-10-22", "Object Oriented Programming", 35),
                new Lecture("2023-10-23", "Data Structures", 40),
                new Lecture("2023-10-24", "Science", 25)
        };

        TextFileHandler textFileHandler = new TextFileHandler("Course Name", "Teacher's Last Name", lectures);
        String textFilePath = "lectures.txt";
        String textFilePath2 = "lecturesSorted.txt";

        try {
            System.out.println();
            textFileHandler.writeToFile(textFilePath, textFileHandler.getLectureList());
            System.out.println("Data written to the text file done lectures.txt.");
            System.out.println("Reading from  text file...");
            Lecture[] textLectures = textFileHandler.readFromFile(textFilePath);
            printLectureArray(textLectures);
            System.out.println("Reading from  text file lectures.txt ... done");
            textFileHandler.sortByTopicAlphabet();
            System.out.println("Sorting Lectures from  text file");
            textFileHandler.writeToFile(textFilePath2, textFileHandler.getLectureList());
            System.out.println("Data written to the text file done lecturesSorted.txt.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        BinaryFileHandler binaryFileHandler = new BinaryFileHandler("Course Name", "Teacher's Last Name", lectures);
        String binaryFilePath = "lectures.dat";
        String binaryFilePath2 = "lecturesSorted.dat";
        System.out.println();

        try {
            System.out.println();
            binaryFileHandler.createBinaryFile(binaryFilePath);
            System.out.println("Data written to the binary file lectures.dat.");
            System.out.println("Reading from  binary file...");
            Lecture[] binaryLectures = binaryFileHandler.readFromFile(binaryFilePath);
            printLectureArray(binaryLectures);
            System.out.println("Reading from  binary file lectures.dat ... done");
            binaryFileHandler.sortByIncreaseNumberWordsTopic();
            System.out.println("Sorting Lectures from  binary file");
            binaryFileHandler.createBinaryFile(binaryFilePath2);
            System.out.println("Data written to the binary file lecturesSorted.dat");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void printLectureArray(Lecture[] textLectures) {
        for (Lecture lecture : textLectures) {
            System.out.println(lecture);
        }
    }
}

