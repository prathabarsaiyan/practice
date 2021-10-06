package main.pratha.MS;

import java.util.*;

/**
 * { 34, 6, 10, 4, 7, 5 }
 *
 *
 *
 * 34,6,10,4,7,5
 *
 *
 * 4, 5, 6, 7
 *
 *
 *
 *
 *
 * {34, 6, 10, 4, 7, 5 ,8,35,55,36,10,2}​
 *
 * {34, 6, 10, 4, 7, 5 ,8,35,55,36,2}​
 *
 * {​10, 55, 2}​
 *
 *
 * 34,35,36
 * 4,5,6,7,8
 */
public class LongestSequence {


    private static int longestSequenceLength(int[] input){
        if(input == null ){
            return 0;
        }

        if(input.length < 2){
            return input.length;
        }

        HashSet<Integer> integerSet = arrayToHashSet(input);
        Iterator<Integer> it = integerSet.iterator();
        int maxCount = 1;
        int currCount,j;
        while(it.hasNext()){
            int i = it.next();

            if(integerSet.contains(i-1)) {
                continue;
            }

            currCount = 1;                        //{ 34, 6, 10, 4, 7, 5}
            while(integerSet.contains(++i)){
                currCount++;
            }

            if(currCount > maxCount){
                maxCount = currCount;
            }
        }

        return maxCount;
    }

    private static HashSet<Integer> arrayToHashSet(int[] input) {
        HashSet<Integer> integerSet = new HashSet<>();
        for(int i: input){
            integerSet.add(i);
        }
        return integerSet;
    }

    public static void main(String[] args) {
        int[]  input1 = {34, 6, 10, 4, 7, 5};
        int[]  input2 = {34, 6, 10, 4, 7, 5 ,8,35,55,36,10,2};
        System.out.println("Input2 :"+longestSequenceLength(input1));
        System.out.println("Input2 :"+longestSequenceLength(input2));

    }

}
