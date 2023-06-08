package jp.ac.ait.k21085;

import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.StudentBase;

import java.util.*;

public class Student extends StudentBase implements IStudent{

    public Student(String studentId, String name, List<Grade> grades){
        this.setStudentId(studentId);
        this.setName(name);
        this.setGrades(grades);
    }
    public Student(){}


    @Override
    public List<Grade> getGradesSortByRatingDsc() {
        List<Grade> tes = new ArrayList<>(getGrades());

        tes.sort((o1, o2) -> {
            if (o1.getMyRating() == o2.getMyRating()) {
                return o1.getSubject().compareTo(o2.getSubject());
            } else if (o1.getMyRating() == 'S' || o2.getMyRating() == 'S') {
                return o2.getMyRating() - o1.getMyRating();
            } else {//評価が同じなら科目で昇順ソート
                return o1.getMyRating() - o2.getMyRating();
            }
        });


        return tes;
    }

    @Override
    public List<Grade> getGradesFilterByRating(char rating) {
        List<Grade> tes = new ArrayList<>();
        for (Grade d : getGrades()) {
            if (d.getMyRating() == rating)tes.add(d);
        }
        return tes;
    }

    @Override
    public List<Grade> getGradesFilterByCreditsEarned() {
        List<Grade> tes = new ArrayList<>();
        for (Grade d : getGrades()) {
            if (d.getMyCredit() >= 1)tes.add(d);
        }
        return tes;
    }

    @Override
    public int getTotalCreditsEarned() {
        int count = 0;
        for (Grade d : getGrades()) {
            count += d.getMyCredit();
        }
        return count;
    }
}
