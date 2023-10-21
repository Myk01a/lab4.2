package org.ntuhpi.task1;

import org.junit.Before;
import org.junit.Test;


import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class CourseSetTest {
    private CourseSet courseSet;

    @Before
    public void setUp() {
        SortedSet<CourseImpl> sortedSet = new TreeSet<>();
        sortedSet.add(new CourseImpl("Course C", "Teacher B", new Lecture[]{new Lecture("2023-01-01", "Topic 1", 50)}));
        sortedSet.add(new CourseImpl("Course A", "Teacher C", new Lecture[]{new Lecture("2023-02-01", "Topic 2", 40)}));
        sortedSet.add(new CourseImpl("Course B", "Teacher A", new Lecture[]{new Lecture("2023-03-01", "Topic 3", 30)}));
        courseSet = new CourseSet(sortedSet);
    }

    @Test
    public void testGetCourseSortedSet() {
        SortedSet<CourseImpl> retrievedSet = courseSet.getCourseSortedSet();
        assertEquals(3, retrievedSet.size());
        assertEquals("Course A", retrievedSet.first().getName());
        assertEquals("Course C", retrievedSet.last().getName());
    }

    @Test
    public void testSortByName() {
        courseSet.sortByName();
        SortedSet<CourseImpl> sortedSet = courseSet.getCourseSortedSet();
        assertEquals("Course A", sortedSet.first().getName());
        assertEquals("Course C", sortedSet.last().getName());
    }

    @Test
    public void testSortByTeacherLastName() {
        courseSet.sortByTeacherLastName();
        SortedSet<CourseImpl> sortedSet = courseSet.getCourseSortedSet();
        assertEquals("Teacher A", sortedSet.first().getTeachersLastName());
        assertEquals("Teacher C", sortedSet.last().getTeachersLastName());
    }
}

