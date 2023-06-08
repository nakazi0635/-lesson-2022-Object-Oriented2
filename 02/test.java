public class test {
    public static void main(String[] args) {

        // この初期化方法によって得られるString型は疑似プリミティブ
        char a = 'H';
        char b = 'H';

        // System.identityHashCode()によってハッシュ値を取得
        System.out.println("a:" + System.identityHashCode(a));
        System.out.println("b:" + System.identityHashCode(b));
        // この時点ではハッシュ値は同じ

        if (a == b) {
            System.out.println("同じだよ！"); // こっち
        } else {
            System.out.println("違うよ！");
        }

        // a,b両方に処理を加えて値を変化させる
        a += 1;
        b += 1;
        System.out.println("a:" + System.identityHashCode(a));
        System.out.println("b:" + System.identityHashCode(b));
        // 文字の連結によって、a,bの参照しているオブジェクトがそれぞれ計算された別のものへと変化した

        if (a == b) {
            System.out.println("同じだよ！");
        } else {
            System.out.println("違うよ！"); // こっち
        }
    }
}