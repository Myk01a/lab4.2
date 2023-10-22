package org.ntuhpi.task3.toZIP;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe", 1);
        Student student2 = new Student("Jane", "Smith", 2);

        AcademicGroup group = new AcademicGroup();
        group.addStudent(student1);
        group.addStudent(student2);

        ZipOutputStream zipOutputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream("academic_group.zip"));
            for (Student student : group.getStudents()) {
                ZipEntry entry = new ZipEntry(student.getStudentId() + ".txt");
                zipOutputStream.putNextEntry(entry);

                PrintWriter writer = new PrintWriter(zipOutputStream);
                writer.println("First Name: " + student.getFirstName());
                writer.println("Last Name: " + student.getLastName());
                writer.println("Student ID: " + student.getStudentId());
                writer.flush();
            }
            zipOutputStream.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
