package jp.ac.ait.k21085;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueString implements IKadai07_3 {

    @Override
    public List<String> getUniqueList(List<String> targetList){
        List<String> uniqelist = new ArrayList<String>();
        int count = 0;
        for (String s_1: targetList){
            for (String s_2: targetList){
                if (s_1 == s_2){
                    count += 1;
                }
            }
            if (count == 1)uniqelist.add(s_1);
            count = 0;
        }
        return uniqelist;
    }


    public static void main(String[] args) {
        UniqueString uni = new UniqueString();
        System.out.println(uni.getUniqueList(Arrays.asList("A", "B", "B", "B", "C")));
        System.out.println(uni.getUniqueList(Arrays.asList("A", "A", "A", "A", "A")));
        System.out.println(uni.getUniqueList(Arrays.asList("A", "B", "C", "D", "E")));
        System.out.println(uni.getUniqueList(Arrays.asList("C", "B", "B", "B", "A")));
    }
}
