public class Fibonacci {
    public IntCollector get(int n){
        int sum = 0;
        int i = 0;
        IntCollector test = new IntCollector();
        test.add(0);
        if (n <= 0){
            test.print();
            return test;
        }
        test.add(1);
        while(true){
            sum = test.getArray()[i]+test.getArray()[i+1];
            if (sum <= n){
                test.add(test.getArray()[i]+test.getArray()[i+1]);
                i++;
            }else {
                break;
            }
        }
        test.print();
        return test;
    }
    
    
    public static void main(String[] args) {
        Fibonacci test_0 = new Fibonacci();
        //test_0.get(-100);
        test_0.get(0);
        test_0.get(100000000);
        //test_0.get(0.27868);
    }
}
