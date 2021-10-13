package main.pratha.booking.hackerrank;

import java.util.PriorityQueue;

/**
 * Given an array of integers arr[] consisting of N integers,
 * the task is to minimize the sum of the given array by performing at most K operations,
 * where each operation involves reducing an array element arr[i] to ceil(arr[i]/2).
 *
 * Input: N = 4, a[] = {20, 7, 5, 4}, K = 3
 * Output: 17
 * Explanation:
 * Operation 1: {20, 7, 5, 4} -> {10, 7, 5, 4}
 * Operation 2: {10, 7, 5, 4} -> {5, 7, 5, 4}
 * Operation 3: {5, 7, 5, 4} -> {5, 4, 5, 4}
 * No further operation can be performed. Therefore, sum of the array = 18.
 *
 * Input: N = 4, a[] = {10, 4, 6, 16}, K = 2
 * Output: 23
 */
public class MinSumKOperations {
    // Function to obtain the minimum possible
    // sum from the array by K reductions
    public static int minSum(int a[], int n, int k)
    {
        // Implements the MaxHeap
        PriorityQueue<Integer> maxheap
                = new PriorityQueue<>((x, y) -> y - x);

        // Insert elements into the MaxHeap
        for (int i = 0; i < n; i++)
            maxheap.add(a[i]);

        while (maxheap.size() > 0 && k > 0) {

            // Remove the maximum
            int max_ele = maxheap.poll();

            // Insert maximum / 2
            maxheap.add((int)Math.ceil(max_ele / 2.0));
            k -= 1;
        }

        // Stores the sum of remaining elements

        int sum = 0;
        while (maxheap.size() > 0)
            sum += maxheap.poll();

        return sum;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        int a[] = { 20, 7, 5, 4 };
        System.out.println(minSum(a, n, k));
    }
}
