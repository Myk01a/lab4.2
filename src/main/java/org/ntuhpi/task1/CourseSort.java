package org.ntuhpi.task1;

import java.util.Arrays;
import java.util.Comparator;

public class CourseSort extends CourseImpl {
    public CourseSort(String name, String teachersLastName, Lecture[] lectureList) {
        super(name, teachersLastName, lectureList);
    }

    @Override
    void sortByIncreaseNumberWordsTopic() {
        if (getLectureList() == null || getLectureList().length <= 1) {
            return;
        }
        Arrays.sort(getLectureList());
    }

    @Override
    void sortByTopicAlphabet() {
        if (getLectureList() == null || getLectureList().length <= 1) {
            return;
        }
        Comparator<Lecture> topicAlphabetComparator = (lecture1, lecture2) ->
                lecture1.getTopic().compareToIgnoreCase(lecture2.getTopic());
        Arrays.sort(getLectureList(), topicAlphabetComparator);
    }

}
