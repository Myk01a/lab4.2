package org.ntuhpi.task1;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CourseListTest {
    private CourseList courseList;

    @Before
    public void setUp() {
        ArrayList<CourseImpl> courses = new ArrayList<>();
        courses.add(new CourseImpl("Course B", "Teacher C", new Lecture[]{new Lecture("2023-01-01", "Topic 1", 50)}));
        courses.add(new CourseImpl("Course C", "Teacher A", new Lecture[]{new Lecture("2023-02-01", "Topic 2", 40)}));
        courses.add(new CourseImpl("Course A", "Teacher B", new Lecture[]{new Lecture("2023-03-01", "Topic 3", 30)}));
        courseList = new CourseList(courses);
    }

    @Test
    public void testGetCourses() {
        ArrayList<CourseImpl> retrievedCourses = courseList.getCourses();
        assertEquals(3, retrievedCourses.size());
        assertEquals("Course B", retrievedCourses.get(0).getName());
        assertEquals("Course C", retrievedCourses.get(1).getName());
        assertEquals("Course A", retrievedCourses.get(2).getName());
    }

    @Test
    public void testSortByName() {
        courseList.sortByName();
        ArrayList<CourseImpl> sortedCourses = courseList.getCourses();
        assertEquals("Course A", sortedCourses.get(0).getName());
        assertEquals("Course B", sortedCourses.get(1).getName());
        assertEquals("Course C", sortedCourses.get(2).getName());
    }

    @Test
    public void testSortByTeacherLastName() {
        courseList.sortByTeacherLastName();
        ArrayList<CourseImpl> sortedCourses = courseList.getCourses();
        assertEquals("Teacher A", sortedCourses.get(0).getTeachersLastName());
        assertEquals("Teacher B", sortedCourses.get(1).getTeachersLastName());
        assertEquals("Teacher C", sortedCourses.get(2).getTeachersLastName());
    }
}
