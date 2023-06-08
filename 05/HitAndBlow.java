package jp.ac.ait.k21085;

import java.util.Scanner;

public class HitAndBlow {
    public static void main(String[] args) {
        Manager app = new Manager();
        Scanner in = new Scanner(System.in);
        Response hb;
        StringUtilities test = new StringUtilities();
        while(true){
            System.out.println("3桁の文字列を入力してください。");
            String str = in.nextLine();
            System.out.println("input " + Answer.DIGITS + " numbers :"+str);

            int len = str.length();
            if (len != Answer.DIGITS || test.isUnsignedInteger(str) == false){
                System.out.println("入力が間違っています");
                return;
            }

            hb = app.solve(str);
            System.out.println("Hit :"+hb.getHit());
            System.out.println("Blow:"+hb.getBlow());

            if (hb.getHit() == Answer.DIGITS){
                System.out.println("試行回数"+app.getCount()+"回");
                break;
            }
        }




    }
}
