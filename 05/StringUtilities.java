package jp.ac.ait.k21085;

public class StringUtilities {
        /**
         * 渡された文字列が正の整数かどうか
         * @param val 正の整数かどうか判断できない文字列
         * @return 正の整数だった場合 true
         */
//    文字列が、符号なしの整数値のみで構成されているかどうかを返すメソッド(直下にサンプルあり)
        public static boolean isUnsignedInteger(String val) {
            if ( val == null || val.length() == 0 ) return false;
            return java.util.regex.Pattern.compile("\\A[0-9]+\\z").matcher(val).find();
        }
}
