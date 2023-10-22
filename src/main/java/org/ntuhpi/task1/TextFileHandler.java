package org.ntuhpi.task1;


import java.io.*;
import java.util.ArrayList;

public class TextFileHandler extends FileHandler {
    public TextFileHandler(String name, String teachersLastName, Lecture[] lectureList) {
        super(name, teachersLastName, lectureList);
    }

    public void createTextFile(String filePath, Lecture[] lectures) throws IOException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (Lecture lecture : lectures) {
                writer.println(lecture.getData() + "," + lecture.getTopic() + "," + lecture.getNumberStudents());
            }
        }
    }
    @Override
    public Lecture[] readFromFile(String filePath) throws IOException {
        ArrayList<Lecture> lectureList = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String data = parts[0];
                    String topic = parts[1];
                    int numberStudents = Integer.parseInt(parts[2]);
                    lectureList.add(new Lecture(data, topic, numberStudents));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Lecture[] lectureArray = new Lecture[lectureList.size()];
        lectureArray = lectureList.toArray(lectureArray);
        return lectureArray;
    }


    @Override
    public void writeToFile(String filePath, Lecture[] lectures) throws IOException {
        createTextFile(filePath, lectures);
    }
}

