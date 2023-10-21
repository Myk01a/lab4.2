package org.ntuhpi.task1;

import java.io.*;
public class BinaryFileHandler extends FileHandler {
    public BinaryFileHandler(String name, String teachersLastName, Lecture[] lectureList) {
        super(name, teachersLastName, lectureList);
    }

    public void createBinaryFile(String filePath) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(getLectureList());
        }
    }

    @Override
    public Lecture[] readFromFile(String filePath) throws IOException, ClassNotFoundException {
        try  {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath));
            return (Lecture[]) inputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToFile(String filePath, Lecture[] lectures) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(lectures);
        }
    }
}

