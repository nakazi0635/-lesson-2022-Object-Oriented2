package jp.ac.ait.k21085;

import java.util.*;

public class PasswordManager {
    public static boolean validate(String password) throws PasswordRulesViolationException {
        boolean test = false;
        Set<String> unusableStringSet = new HashSet<>(Arrays.asList(
                "password", "p@ssw0rd", "p@55w0rd", "qwerty", "asdfgh", "zxcvbn", "abcdef", "123456"));
        List<Character> symbolList = Arrays.asList(',', '.', '+', '-', '*', '/', '=', '_', '#', '!', '?', '@', ' ');

        if (password.length() <= 16 || password.length() >= 128){//文字制限設定
            throw new PasswordRulesViolationException("パスワードは16文字以上128文字以下にしてください。");
        }

        boolean Upper = false;
        boolean Lower = false;
        boolean Digit = false;
        boolean Symbol = false;//大文字、小文字、数字、記号が含まれているか判定する
        for (char c : password.toCharArray()){
            if (!Character.isUpperCase(c) && !Character.isLowerCase(c) && !Character.isDigit(c)){//「<」「>」など使用できない文字があるか判定
                if (!symbolList.contains(c))throw new PasswordRulesViolationException("設定できない記号が含まれています。");
            }
            if (Character.isUpperCase(c))Upper = true;
            if (Character.isLowerCase(c))Lower = true;
            if (Character.isDigit(c))Digit = true;
            for (char s : symbolList){
                if (c == s)Symbol = true;
            }
        }
        if (!Upper || !Lower || !Digit ||!Symbol){//それぞれが含まれていないのがある時、
            throw new PasswordRulesViolationException("パスワードには必ず、大文字のアルファベット、小文字のアルファベット、数字、記号のうちそれぞれ一文字以上使用する必要があります。");
        }

        String passwordlow = password.toLowerCase();//含めてはいけない文字列を判定するため、小文字に変換
        for (String s : unusableStringSet){
            if (passwordlow.contains(s)){//containsを使って使用できない文字列があるか判定
                throw new PasswordRulesViolationException("容易に推測されるパスワードに設定できません");
            }
        }
        return test;
    }
}
