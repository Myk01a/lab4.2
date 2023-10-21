package org.ntuhpi.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CourseList {
    private ArrayList<CourseImpl> courses;

    public CourseList(ArrayList<CourseImpl> courses) {
        this.courses = courses;
    }

    public ArrayList<CourseImpl> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<CourseImpl> courses) {
        this.courses = courses;
    }

    public void sortByName() {
        Collections.sort(courses, new Comparator<CourseImpl>() {
            @Override
            public int compare(CourseImpl course1, CourseImpl course2) {
                return course1.getName().compareTo(course2.getName());
            }
        });
    }

    public void sortByTeacherLastName(){
        Collections.sort(courses, new Comparator<CourseImpl>() {
            @Override
            public int compare(CourseImpl course1, CourseImpl course2) {
                return course1.getTeachersLastName().compareTo(course2.getTeachersLastName());
            }
        });
    }

    @Override
    public String toString() {
        return "CourseList{" +
                "courses=" + courses +
                '}';
    }
    public void print(){
        for (CourseImpl course : courses) {
            System.out.println(course.toString());
        }
    }
}
