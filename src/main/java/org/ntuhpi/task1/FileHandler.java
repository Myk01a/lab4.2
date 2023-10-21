package org.ntuhpi.task1;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandler extends CourseSort {
    public FileHandler(String name, String teachersLastName, Lecture[] lectureList) {
        super(name, teachersLastName, lectureList);
    }

    public abstract Lecture[] readFromFile(String filePath) throws IOException, ClassNotFoundException;

    public abstract void writeToFile(String filePath, Lecture[] sortedLectures) throws IOException;
}

