package jp.ac.ait.k21085;

import java.util.*;


public class NonUniqueElements implements IKadai07_4 {

    @Override
    public void convert(List<Integer> targetList){
        int count;

//        int i = 0;
//        System.out.println(targetList);
//        for (int s_1: targetList){
//            count = 0;
//            System.out.println(s_1);
//            for (int s_2: targetList){
//                if (s_1 == s_2){
//                    count += 1;
//                }
//            }
//            if (count == 1){
//                targetList.remove(i);
//            }
//            i++;
//        }


        Iterator<Integer> itr = targetList.iterator();
        while (itr.hasNext()){
            count = 0;
            int num = itr.next();
            for (int s_2: targetList){
                if (num == s_2){
                    count += 1;
                }
            }
            if (count == 1)itr.remove();
        }
    }


    public static void main(String[] args) {
        NonUniqueElements uni = new NonUniqueElements();
        List<Integer> l_0 = new LinkedList<>(Arrays.asList(1, 2, 3, 1, 3));
        uni.convert(l_0);
        System.out.println(l_0);

        List<Integer> l_1 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        uni.convert(l_1);
        System.out.println(l_1);

        List<Integer> l_2 = new LinkedList<>(Arrays.asList(5, 5, 5, 5, 5));
        uni.convert(l_2);
        System.out.println(l_2);

        List<Integer> l_3 = new LinkedList<>(Arrays.asList(10, 9, 10, 10, 9, 8));
        uni.convert(l_3);
        System.out.println(l_3);

        List<Integer> l_4 = new LinkedList<>(Arrays.asList(-5, -4, 8, 2, -4));
        uni.convert(l_4);
        System.out.println(l_4);
    }
}