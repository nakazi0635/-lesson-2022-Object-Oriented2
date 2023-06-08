import java.util.Scanner;


/*ScoresManagerでは、mainメソッドだけを持たせ、生徒の出席番号、氏名、各教科の点数を標準入力より入力させます。

        入力が終わったら、printInfoメソッドを用いて標準出力にデータを出力します。

        ※このクラスのmainメソッドの実装方法及び入力の流れなどは、各自で考えて実装を行うこととします。*/
public class ScoresManager {
    public static void main(String[] args) {
        Score f = new Score();

        Scanner in = new Scanner(System.in);
        System.out.println("出席番号を入力してください。");
        f.id = Integer.parseInt(in.nextLine());

        System.out.println("氏名を入力してください。");
        f.name = in.nextLine();

        System.out.println("国語の点数を入力してください。");
        f.setJapanese(Integer.parseInt(in.nextLine()));

        System.out.println("数学の点数を入力してください。");
        f.setMathmatics(Integer.parseInt(in.nextLine()));

        System.out.println("理科の点数を入力してください。");
        f.setScience(Integer.parseInt(in.nextLine()));

        System.out.println("社会の点数を入力してください。");
        f.setSocialStudies(Integer.parseInt(in.nextLine()));

        System.out.println("英語の点数を入力してください。");
        f.setEnglish(Integer.parseInt(in.nextLine()));

        //f.getJapanese(Integer.parseInt(in.nextLine()));

        /*
         * System.out.println("テストの点数を入力してください。点数([0]:国語,[1]:数学,[2]:理科,[3]:社会,[4]:英語)");
         * String subjects = in.nextLine();
         * f.subjects = Integer.parseInt(subjects);
         */

        //System.out.println(f.id);
        //System.out.println(f.name);
        f.printInfo();
        in.close();
    }
}