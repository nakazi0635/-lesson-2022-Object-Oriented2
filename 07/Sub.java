public class Sub extends Super {
    public void print() {
        System.out.println("Sub : " + name);
    }
    public static void main(String[] args) {
        Super a, b;
        a = new Super();
        b = new Sub();
        a.name = "A";
        b.name = "B";
        a.print();
        b.print();
    }
}