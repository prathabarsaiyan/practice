package main.pratha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all zero sum triplets
 * Input : arr[] = {0, -1, 2, -3, 1}
 * Output : (0 -1 1), (2 -3 1)
 *
 * Explanation : The triplets with zero sum are
 * 0 + -1 + 1 = 0 and 2 + -3 + 1 = 0
 *
 * Input : arr[] = {1, -2, 1, 0, 5}
 * Output : 1 -2  1
 * Explanation : The triplets with zero sum is
 * 1 + -2 + 1 = 0
 */
public class ZeroSumTriplets {

    public static void main(String[] args) {
        int[] a = {-8, 1,6,2,3,5,-6,12};
        System.out.println(findZeroSumTriplets(a));
    }

    private static List<List<Integer>> findZeroSumTriplets(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(a);
        int n = a.length;

        for(int i = 0; i < n-1; i++){
            res.addAll(findSumPair(a, i, n));
        }
        return  res;
    }

    private static List<List<Integer>> findSumPair(int[] a, int i, int n) {
        int sum;
        int x = i+1, y = n-1;
        List<List<Integer>> res = new ArrayList<>();
        while(x < y){
            sum = a[x]+a[y]+a[i];
            if(sum == 0){
                res.add(Arrays.asList(a[i], a[x], a[y]));
                x++;
                y--;
            } else if (sum < 0){
                x++;
            } else{
                y--;
            }
        }
        return res;
    }
}
