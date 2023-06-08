package jp.ac.ait.k21085;

import java.util.ArrayList;
import java.util.List;
import jp.ac.ait.oop1.section09.Grade;
import jp.ac.ait.oop1.section09.IStudent;

public class Main {
    public static void main(String[] args) {
        List<Grade> data_0 = new ArrayList<>();
        data_0.add(new Grade("jap", 2, 'A'));
        data_0.add(new Grade("mat", 3, 'Q'));
        data_0.add(new Grade("sci", 1, 'F'));
        data_0.add(new Grade("soc", 1, 'C'));
        data_0.add(new Grade("eng", 2, 'S'));


        List<Grade> data_1 = new ArrayList<>();
        data_1.add(new Grade("jap", 2, 'A'));
        data_1.add(new Grade("mat", 3, 'S'));
        data_1.add(new Grade("sci", 1, 'C'));
        data_1.add(new Grade("soc", 1, 'A'));
        data_1.add(new Grade("eng", 2, 'S'));


        List<Grade> data_2 = new ArrayList<>();
        data_2.add(new Grade("jap", 2, 'S'));
        data_2.add(new Grade("mat", 3, 'Q'));
        data_2.add(new Grade("sci", 1, 'F'));
        data_2.add(new Grade("soc", 1, 'F'));
        data_2.add(new Grade("eng", 2, 'F'));

//        List<Grade> data_3 = new ArrayList<>();
//        data_3.add(new Grade("jap", 2, 'SS'));
//        data_3.add(new Grade("mat", 3, 'QA'));
//        data_3.add(new Grade("sci", 1, 'FS'));
//        data_3.add(new Grade("sor", 1, 'FS'));
//        data_3.add(new Grade("eng", 2, 'FX'));

//        List<Grade> data_4 = new ArrayList<>();
//        data_4.add(new Grade("jap", 2, 'W'));
//        data_4.add(new Grade("mat", 3, 'R'));
//        data_4.add(new Grade("sci", 1, 'T'));
//        data_4.add(new Grade("sor", 1, 'V'));
//        data_4.add(new Grade("eng", 2, 'Z'));




        List<IStudent> ISdata = new ArrayList<>();//ISstudentのリスト作成。元データ
        ISdata.add(new Student("0703","nakazi", data_0));//取得単位8
        ISdata.add(new Student("0411","siraki", data_1));//取得単位9
        ISdata.add(new Student("0221","hosino", data_2));//取得単位2

        System.out.println("元単位データ");
        for (IStudent d : ISdata){//比較するため元データ表示
            System.out.println(d);
        }
        System.out.println();

        StudentsSorter test = new StudentsSorter();//StudentsSorterクラスをインスタンス化
        test.setStudents(ISdata);//set関数でインスタンス化したtestに登録

        System.out.println("昇順単位データ");
        for (IStudent d : test.sortByTotalCreditsEarnedAsc()){//単位昇順クラスを実行しながら拡張for回す
            System.out.println(d);
        }
        System.out.println();

        System.out.println("降順単位データ");
        for (IStudent d : test.sortByTotalCreditsEarnedDsc()){//単位降順クラスを実行しながら拡張for回す
            System.out.println(d);
        }
        System.out.println();

        Student stu = new Student();
        stu.setGrades(data_0);
        System.out.println("nakaziのデータ");
        System.out.println("成績を評価の降順で並び替えして取得");
        System.out.println(stu.getGradesSortByRatingDsc());
        char eva = 'S';
        System.out.println(eva +"評価の成績リストを取得する");
        System.out.println(stu.getGradesFilterByRating(eva));
        System.out.println("単位取得できた成績リストを取得する");
        System.out.println(stu.getGradesFilterByCreditsEarned());
        System.out.println("単位の総取得数");
        System.out.println(stu.getTotalCreditsEarned());
    }
}
