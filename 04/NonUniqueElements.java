public class NonUniqueElements {
    public IntCollector convent(IntCollector arr) {
        int len = arr.getArray().length;
        arr.print();
        for (int i = 0; i < len; i++) {
            if (arr.countOf(arr.getArray()[i]) == 1){
                arr.remove(i);
                i -= 1;
                len -= 1;
            }
        }
        return arr;
    }

    @Override
    public String toString() {
        return "override";
    }

    public static void main(String[] args) {
        NonUniqueElements non = new NonUniqueElements();

        int[] test_0 = {1,2,3,1,3};
        IntCollector array_0 = new IntCollector(test_0);
        non.convent(array_0);
        array_0.print();
        System.out.println();
        //System.out.println(non.toString());

        int[] test_1 = {1,2,3,4,5};
        IntCollector array_1 = new IntCollector(test_1);
        non.convent(array_1);
        array_1.print();
        System.out.println();

        int[] test_2 = {5,5,5,5,5};
        IntCollector array_2 = new IntCollector(test_2);
        non.convent(array_2);
        array_2.print();
        System.out.println();

        int[] test_3 = {-1,-1,-54,-4,-214,-6,-87465,-8,-999,-999};
        IntCollector array_3 = new IntCollector(test_3);
        non.convent(array_3);
        array_3.print();
        System.out.println();

    }
}
