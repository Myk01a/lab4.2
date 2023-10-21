package org.ntuhpi.task1;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lab3 {
    public static void main(String[] args) {
        Lecture[] lectures = {
                new Lecture("2023-01-01", "Topic 1", 50),
                new Lecture("2023-02-01", "Topic 2", 40),
                new Lecture("2023-03-01", "Topic 3", 30)
        };

        CourseImpl courseA = new CourseImpl("Java", "Schmidt", lectures);
        CourseImpl courseB = new CourseImpl("Python", "Abrams", lectures);
        CourseImpl courseC = new CourseImpl("Kotlin", "Terry", lectures);

        ArrayList<CourseImpl> courseList = new ArrayList<>();
        courseList.add(courseA);
        courseList.add(courseB);
        courseList.add(courseC);

        CourseList courseListInstance = new CourseList(courseList);

        System.out.println();
        System.out.println("Courses in the CourseList (sorted by name):");
        courseListInstance.sortByName();
        courseListInstance.print();

        System.out.println();
        System.out.println("Courses in the CourseList (sorted by teacher's last name):");
        courseListInstance.sortByTeacherLastName();
        courseListInstance.print();
        System.out.println();

        SortedSet<CourseImpl> courseSet = new TreeSet<>();
        courseSet.add(courseB);
        courseSet.add(courseC);
        courseSet.add(courseA);

        CourseSet courseSetInstance = new CourseSet(courseSet);

        SortedSet<CourseImpl> retrievedSet = courseSetInstance.getCourseSortedSet();
        CourseSet courseSortedNameSet = new CourseSet(retrievedSet);
        System.out.println("Courses in the CourseSet (sorted by name):");
        courseSortedNameSet.print();

        System.out.println();
        courseSetInstance.sortByTeacherLastName();
        SortedSet<CourseImpl> sortedByTeacherLastNameSet = courseSetInstance.getCourseSortedSet();
        System.out.println("Courses in the CourseSet (sorted by teacher's last name):");
        CourseSet courseSortedTeacherNameSet = new CourseSet(sortedByTeacherLastNameSet);
        courseSortedTeacherNameSet.print();

        System.out.println();
        courseSetInstance.sortByName();
        SortedSet<CourseImpl> sortedByNameSet = courseSetInstance.getCourseSortedSet();
        System.out.println("Courses in the CourseSet (sorted by name again):");

        for (CourseImpl course : sortedByNameSet) {
            System.out.println(course.toString());
        }
    }
}
