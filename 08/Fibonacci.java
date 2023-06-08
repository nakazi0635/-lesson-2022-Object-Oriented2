package jp.ac.ait.k21085;

import java.util.List;
import java.util.ArrayList;


public class Fibonacci implements IKadai07_1 {

    @Override
    public List<Integer> get(int judge) {
        List<Integer> fiboList = new ArrayList<Integer>();
        if (judge < 0){
            return fiboList;
        }
        fiboList.add(0);
        if (judge == 0){
            return fiboList;
        }
        fiboList.add(1);
        int i = 0;
        int sum;

        while (true) {
            sum = fiboList.get(i) + fiboList.get(i + 1);
            if (sum <= judge) {
                fiboList.add(fiboList.get(i) + fiboList.get(i + 1));
                i++;
            } else {
                break;
            }
        }
        return fiboList;
    }


    public static void main(String[] args) {
        Fibonacci fiboList = new Fibonacci();
        System.out.println(fiboList.get(10000));
        System.out.println(fiboList.get(55));
        System.out.println(fiboList.get(0));
        System.out.println(fiboList.get(1));
        System.out.println(fiboList.get(-1));
    }
}

