import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class AtodashiJanken {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int R_num = new java.util.Random().nextInt(3);

        String cpu_hand = R_num == 0 ? "グー" : R_num == 1 ? "チョキ" : "パー";
        System.out.println("CPUは"+cpu_hand+"を出します");

        System.out.println("何を出しますか？(0:グー,1:チョキ,2:パー）");
        int M_num = Integer.parseInt(in.nextLine());
        String my_hand = M_num == 0 ? "グー" : M_num == 1 ? "チョキ" : "パー";
        System.out.println("あなたは"+my_hand+"を出しました");
        switch (M_num){
            case 0:
                System.out.println(R_num == 0 ? "あいこです" : R_num == 1 ? "あなたの勝ち" : "あなたの負け");
                break;
            case 1:
                System.out.println(R_num == 0 ? "あなたの負け" : R_num == 1 ? "あいこです" : "あなたの勝ち");
                break;
            default:
                System.out.println(R_num == 0 ? "あなたの勝ち" : R_num == 1 ? "あなたの負け" : "あいこです");
                break;
        }
        in.close();





//        Scanner in = new Scanner(System.in);
//        int R_num = new java.util.Random().nextInt(3);
//        if (R_num == 0) {
//            System.out.println("コンピューターはグーを出します");
//        } else if (R_num == 1) {
//            System.out.println("コンピューターはチョキを出します");
//        } else {
//            System.out.println("コンピューターはパーを出します");
//        }
//        System.out.println("何を出しますか？(0:グー,1:チョキ,2:パー）");
//        String inputLine = in.nextLine();
//        int M_num = Integer.parseInt(inputLine);
//        if ((M_num == 0 && R_num == 1) || (M_num == 1 && R_num == 2) || (M_num == 2 && R_num == 0)) {
//            System.out.println("あなたの勝ち");
//        } else if ((M_num == 0 && R_num == 2) || (M_num == 1 && R_num == 0) || (M_num == 2 && R_num == 1)) {
//            System.out.println("あなたの負け");
//        } else if (M_num == R_num) {
//            System.out.println("あいこです");
//        } else {
//            System.out.println("あなたの出した手が判断できません。勝負はしません。");
//        }
//        in.close();
    }
}
