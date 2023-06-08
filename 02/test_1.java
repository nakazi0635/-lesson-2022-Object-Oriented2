public class test_1 {
    public static void main(String[] args) {

        String a = "Hello";
        String b = "Hello";

        System.out.println("a:" + System.identityHashCode(a));
        System.out.println("b:" + System.identityHashCode(b));

        if (a.equals(b)) {
            System.out.println("同じだよ！"); // こっち
        } else {
            System.out.println("違うよ！");
        }

        a += 1;
        b += 1;
        System.out.println("a:" + System.identityHashCode(a));
        System.out.println("b:" + System.identityHashCode(b));

        if (a.equals(b)) {
            System.out.println("同じだよ！"); // こっち
        } else {
            System.out.println("違うよ！");
        }
    }
}