package org.ntuhpi.task3.toZIP;

import java.util.ArrayList;
import java.util.List;

public class AcademicGroup {
    private List<Student> students;

    public AcademicGroup(List<Student> students) {
        this.students = students;
    }
    public AcademicGroup() {
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}

