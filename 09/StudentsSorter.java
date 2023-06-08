package jp.ac.ait.k21085;
import jp.ac.ait.oop1.section09.IStudent;
import jp.ac.ait.oop1.section09.IStudentsSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsSorter implements IStudentsSorter {

    private List<IStudent> IStudent;

    @Override
    public List<IStudent> getStudents() {
        return IStudent;
    }

    @Override
    public void setStudents(List<IStudent> students) {
        this.IStudent = students;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedAsc() {
        List<IStudent> testlist = new ArrayList<>(getStudents());//元データをコピー
        Collections.sort(testlist, (o1,o2) -> o1.getTotalCreditsEarned() - o2.getTotalCreditsEarned());//studentクラスで作った。合計取得単位を求める関数をつかって昇順ソート


//        Collections.sort(testlist, new Comparator<>() {
//            @Override
//            public int compare(IStudent o1, IStudent o2) {
//                return o1.getTotalCreditsEarned() - o2.getTotalCreditsEarned();//studentクラスで作った。合計取得単位を求める関数をつかって昇順ソート
//            }
//        });

        return testlist;
    }

    @Override
    public List<IStudent> sortByTotalCreditsEarnedDsc() {
        List<IStudent> testlist = new ArrayList<>(getStudents());//元データをコピー
        Collections.sort(testlist, (o1,o2) -> o2.getTotalCreditsEarned() - o1.getTotalCreditsEarned());
        return testlist;
    }
}
