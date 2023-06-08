import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("素数判断する値を入力してください");
        int num = Integer.parseInt(in.nextLine());
        boolean judge = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                judge = false;
                break;
            }
        }
        if (judge) {
            System.out.printf("%dは素数です\n", num);
        } else {
            System.out.printf("%dは素数ではありません\n", num);
        }
        in.close();
    }
}
