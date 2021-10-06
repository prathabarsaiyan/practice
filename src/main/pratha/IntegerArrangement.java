package main.pratha;

import java.util.*;
/*
 * Complete the 'arrangements' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER n as parameter.

 1 - 1 - [1]
 2 - 2 - [1,2],[2,1]
 3 - 3 - [1,2,3], [3,2,1], [2,1,3]
 4 - 8 - [4,3,1,2], [3,1,2,4], [4,1,2,3], [1,2,3,4], [4,3,2,1], [3,2,1,4], [4,2,1,3],[2,1,3,4]

 */
public class IntegerArrangement {


    public static int arrangements(int n) {

        int[] arr = new int[n];
        for(int i= 0; i<n; i++){
            arr[i] = i+1;
        }

        Set<int[]> permutations = new HashSet<>();
        permutations.add(arr);
        getPermutation(0, n-1, arr, permutations);
        return countValidCombinations(permutations);
    }

    static int countValidCombinations(Set<int[]> permutations){
        int count = 0;
        for(int[] combination: permutations){
            if(isValidCombination(combination)){
                count++;
            }
        }
        return count;
    }

    static boolean isValidCombination(int[] combination){
        for(int i = 0; i< combination.length; i++){
            if(combination[i]% (i+1) == 0
                    || (i+1)% combination[i] == 0){
                continue;
            }
            return false;
        }
        return true;
    }


    static void getPermutation(int i, int j, int[] arr, Set<int[]> permutations){
        if(i == j){
            System.out.println(arr);
            permutations.add(arr);
        }
        for(int m = i; m <= j;m++){
            int[] temp = arr;
            swap(i, m, temp);
            getPermutation(i+1, j, temp, permutations);
            swap(i, m, temp);
        }
    }

    static void swap(int i, int j, int[] arr){
        if(i == j){
            return;
        }
        System.out.println(i+" ::"+j+" ::"+arr);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        System.out.println(arrangements(4));
    }
}
