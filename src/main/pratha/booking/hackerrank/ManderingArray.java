package main.pratha.booking.hackerrank;

import java.util.*;

/**
 * Given an array of integers, task is to print the array in the order – smallest number, Largest number, 2nd smallest number, 2nd largest number, 3rd smallest number, 3rd largest number and so on…..
 * Examples:
 *
 *
 * Input : arr[] = [5, 8, 1, 4, 2, 9, 3, 7, 6]
 * Output :arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5}
 *
 * Input : arr[] = [1, 2, 3, 4]
 * Output :arr[] = {1, 4, 2, 3}
 */
public class ManderingArray {
    static List<Integer> manderingArray(List<Integer> arr){
        Collections.sort(arr);
        List<Integer> sorted = new ArrayList<>();

        int n = arr.size(), i =0;
        for(; i < n/2;i++){
            sorted.add(arr.get(n-1-i));
            sorted.add(arr.get(i));
        }

        if(n%2 != 0){
            sorted.add(arr.get(i));
        }
        return sorted;
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(5);
        arr.add(4);
        arr.add(2);
        arr.add(6);
        System.out.println(manderingArray(arr));
    }
}
