package main.pratha;

import java.util.Stack;

/**
 * Given an array A of n integers. The task is to find the sum of minimum of all possible (contiguous) subarray of A.
 *
 * Input: A =       [3, 1, 2, 4]
 *
 *
 * i = 0
 *  minLeft = 0, minRight = 0
 *
 * i = 1
 *  minLeft = 0, minRight = 3
 *
 * i = 2
 *  minLeft = 2, minRight = 3
 *
 * i = 3
 *  minLeft = 3, minRight = 3
 *
 *
 *
 *
 *
 * n=4
 *
 * i = 0
 *  comb = (minLeft+1) * (n - minRight-minLeft)  = 4
 *
 * i = 1
 *  comb = (i+1) * (n-i) = 6
 *
 * i = 2
 *  comb = (i+1) * (n-i) = 6
 *
 * i = 3
 *  comb = (i+1) * (n-i) = 4
 *
 *
 *    i = 2
 * comb = (i+1) * (n-i)
 * for i= 0..n
 *  min = a[i]
 *  for j = i...n{
 *     if(a[j]< min){
 *         min = a[j];
 *     }
 *     sum+= min;
 *  }
 *
 *  i = 0, j = 0, min = 3, sum = 3
 *     3
 * i = 0, j = 1, min = 1, sum = 4
 *     3,1
 * i = 0, j = 2, min = 1, sum = 4
 *     3,1,2
 *
 * i = 0, j = 3
 *  3, 1, 2, 4
 *
 * possible Subarray
 * 3,1,2,4 = 1
 * 3,1,2 = 1
 * 3,1 = 1
 * 3 = 3
 *
 * 1,2,4 = 1
 * 1,2 = 1
 * 1 = 1
 *
 * 2, 4 = 2
 * 2 = 2
 *
 *
 * 4 = 4
 *
 * Output: 17
 *
 * Input : A = [1, 2, 3, 4]
 * Output : 20
 */
public class SumOfMiniOfAllSubarray {

    static class pair
    {
        int first, second;
        public pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    // Function to return required minimum sum
    static int sumSubarrayMins(int A[], int n)
    {
        int []left = new int[n];
        int []right = new int[n];

        Stack<pair> s1 = new Stack<pair>();
        Stack<pair> s2 = new Stack<pair>();

        // getting number of element strictly larger
        // than A[i] on Left.
        for (int i = 0; i < n; ++i)
        {
            int cnt = 1;

            // get elements from stack until element
            // greater than A[i] found
            while (!s1.isEmpty() &&
                    (s1.peek().first) > A[i])
            {
                cnt += s1.peek().second;
                s1.pop();
            }

            s1.push(new pair(A[i], cnt));
            left[i] = cnt;
        }

        // getting number of element larger
        // than A[i] on Right.
        for (int i = n - 1; i >= 0; --i)
        {
            int cnt = 1;

            // get elements from stack until element
            // greater or equal to A[i] found
            while (!s2.isEmpty() &&
                    (s2.peek().first) >= A[i])
            {
                cnt += s2.peek().second;
                s2.pop();
            }

            s2.push(new pair(A[i], cnt));
            right[i] = cnt;
        }

        int result = 0;

        // calculating required resultult
        for (int i = 0; i < n; ++i)
            result = (result + A[i] * left[i] *
                    right[i]);

        return result;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int A[] = { 3, 1, 2, 4 };

        int n = A.length;

        // function call to get required result
        System.out.println(sumSubarrayMins(A, n));
    }

}
