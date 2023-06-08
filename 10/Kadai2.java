package jp.ac.ait.k21085;

import java.util.Scanner;

public class Kadai2 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("設定したいパスワードを入力してください");
        String input = sc.nextLine();
        try{
            PasswordManager.validate(input);
        }catch (Exception e){
            System.out.printf("パスワードのルール基準を満たしていません。%s \n", e.getMessage());
        }
    }
}
