
public class UtilityMethods {

    public void printCurrency(double dou_1) {
        System.out.printf("%.2f\n", dou_1);
    }

    public int add(int num_1, int num_2) {
        int num = num_1 + num_2;
        return num;
    }

    public double division(int num_1, int num_2) {
        double dou;
        dou = (double) num_2 / (double) num_1;
        return dou;
    }

    public String getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything() {
        String str = "750ミリ後に表示されるよ!";
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
        }
        return str;
    }

    public static void main(String[] args) {

        String str_1;

        UtilityMethods app = new UtilityMethods();

        System.out.println("浮動小数点メソッド");
        app.printCurrency(1.00);
        app.printCurrency(12345.6789);

        System.out.println("整数加算メソッド");
        System.out.println(app.add(-100,200));
        System.out.println(app.add(0,0));
        System.out.println(app.add(100000,100000));


        System.out.println("整数値同士の除算メソッド");
        System.out.println(app.division(10,5));
        System.out.println(app.division(1,5));
        System.out.println(app.division(10,3));

        str_1 = app.getTheAnswerToTheUltimateQuestionOfLife_TheUniverse_And_Everything();
        System.out.println(str_1);
    }
}
