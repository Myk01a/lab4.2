package org.ntuhpi.task1;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class CourseSet {
    private SortedSet<CourseImpl> courseSortedSet;

    public CourseSet(SortedSet<CourseImpl> courseSortedSet) {
        this.courseSortedSet = courseSortedSet;
    }

    public SortedSet<CourseImpl> getCourseSortedSet() {
        return courseSortedSet;
    }

    public void setCourseSortedSet(SortedSet<CourseImpl> courseSortedSet) {
        this.courseSortedSet = courseSortedSet;
    }

    public void sortByName() {
        Comparator<CourseImpl> nameComparator = Comparator.comparing(CourseImpl::getName);

        SortedSet<CourseImpl> sortedByNameSet = new TreeSet<>(nameComparator);
        sortedByNameSet.addAll(courseSortedSet);

        courseSortedSet = sortedByNameSet;
    }

    public void sortByTeacherLastName(){
        Comparator<CourseImpl> teacherLastNameComparator = Comparator.comparing(CourseImpl::getTeachersLastName);

        SortedSet<CourseImpl> sortedByTeacherLastNameSet = new TreeSet<>(teacherLastNameComparator);
        sortedByTeacherLastNameSet.addAll(courseSortedSet);

        courseSortedSet = sortedByTeacherLastNameSet;
    }
    public void print(){
        for (CourseImpl course : courseSortedSet) {
            System.out.println(course.toString());
        }
    }
}
