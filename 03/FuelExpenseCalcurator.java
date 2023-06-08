import java.util.Scanner;
public class FuelExpenseCalcurator {
    //run	double	double mileage	走行距離を引数で渡し、累計走行距離に加算、走行距離 / 燃費を消費燃料として消費燃料の累計に加算、今回の走行で消費した燃料を返します
    //printInfo	なし	なし	標準出力に「走行距離:00.00km 消費燃料:00.00L」のように情報出力してください。
    //FuelExpenseCalcuratorでは、mainメソッドだけを持たせ、適当な燃費の車を生成し、標準入力より走行距離を入力させます。

    //走行距離の入力は、実数での入力を想定していますが、何度も入力させたいので、文字列で「end」と入力されるまで繰り返します。
    //走行距離が入力される都度、生成した車のrunメソッドを呼び出し、走行距離、消費燃料を計算させます。 計算が終わったら、printInfoメソッドを用いて標準出力にデータを出力します。

    //入力待受で「end」が入力されたらプログラムを終了してください。

    //※このクラスのmainメソッドの実装方法及び入力の流れなどは、各自で考えて実装を行うこととします。
    public static void main(String[] args) {
        Car f = new Car();
        f.fuelEfficiency = 20.0;
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("走行距離を続けて改行区切りで入力してください。(endを入力すると終了します。)");
            String id = in.nextLine();
            if (id.equals("end")){
                return;
            }else{
                System.out.println(f.run(Double.parseDouble(id)));
                f.printInfo();
            }
        }
    }
}
