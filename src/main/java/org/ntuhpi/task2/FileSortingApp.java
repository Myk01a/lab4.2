package org.ntuhpi.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileSortingApp {

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String increasingOutputFilePath = "increasing.txt";
        String decreasingOutputFilePath = "decreasing.txt";

        try {
            List<Integer> numbers = readNumbersFromFile(inputFilePath);

            sortAndWriteToFile(numbers, increasingOutputFilePath, new IncreasingSumComparator());
            sortAndWriteToFile(numbers, decreasingOutputFilePath, new DecreasingSumComparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numberStrings = line.split(" ");
                for (String numberStr : numberStrings) {
                    try {
                        int number = Integer.parseInt(numberStr);
                        if (number >= 0) {
                            numbers.add(number);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        return numbers;
    }

    private static void sortAndWriteToFile(List<Integer> numbers, String outputPath, Comparator<Integer> comparator)
            throws IOException {
        Collections.sort(numbers, comparator);
        try (PrintWriter writer = new PrintWriter(outputPath)) {
            for (Integer number : numbers) {
                writer.println(number);
            }
        }
    }
}

