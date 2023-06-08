package jp.ac.ait.k21085;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FizzBuzz implements IKadai07_2{

    @Override
    public List<String> getConverted(List<Integer> targetList){
        List<String> fizzbuzzlist = new ArrayList<String>();
        for (int num: targetList) {
            if (num % 3 == 0 && num % 5 == 0) {
                fizzbuzzlist.add("FizzBuzz");
            }else if (num % 3 == 0) {
                    fizzbuzzlist.add("Fizz");
            }else if (num % 5 == 0) {
                    fizzbuzzlist.add("Buzz");
            }else{
                fizzbuzzlist.add(Integer.toString(num));
            }
        }
        return fizzbuzzlist;
    }


    public static void main(String[] args) {
        FizzBuzz fibu = new FizzBuzz();
        System.out.println(fibu.getConverted(Arrays.asList(1, 2, 3, 4, 5)));
        System.out.println(fibu.getConverted(Arrays.asList(1, 2, 4)));
        System.out.println(fibu.getConverted(Arrays.asList(12, 13, 14, 15, 16)));
        System.out.println(fibu.getConverted(Arrays.asList(3, 30, 300)));
        System.out.println(fibu.getConverted(Arrays.asList(-13, -100, -299)));
        System.out.println(fibu.getConverted(Arrays.asList()));
    }
}
