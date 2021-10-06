package main.pratha;
/**
Problem Name is &&& Second Smallest &&& PLEASE DO NOT REMOVE THIS LINE.

 * find second smallest element in array x. If x has fewer than 2 elements returns 0.
 */

public class SecondSmallestProblem
{

    public static int secondSmallest(int[] x)
    {

        int n = x.length;

        if(n < 2){
            return 0;
        }

        int min, secMin;

        if(x[0] > x[1]){
            secMin = x[0];
            min = x[1];
        } else {
            secMin = x[1];
            min = x[0];
        }

        for(int i =2; i< n;i++){
            if(x[i] < min){
                secMin = min;
                min = x[i];
            } else if(x[i] < secMin){
                secMin = x[i];
            }
        }

        return secMin;
    }

    /**
     * bool doTestsPass()
     * Runs various tests. Returns true if tests pass. Otherwise,
     * returns false.
     */
    public static boolean doTestsPass()
    {
        // todo: implement more tests, please
        // feel free to make testing more elegant
        int[] a = {0};
        int[] b = {0,1};
        int[] c = {0,1,-1,-2};

        boolean result = true;
        result &= secondSmallest( a ) == 0;
        result &= secondSmallest( b ) == 1;
        result &= secondSmallest( c ) == -1;

        if(result)
        {
            System.out.println("All tests pass\n");
        }
        else
        {
            System.out.println("There are test failures\n");
        }
        return result;
    }

    /**
     * Execution entry point.
     */
    public static void main(String args[])
    {
        doTestsPass();
    }
}