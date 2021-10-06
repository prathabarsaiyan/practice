package main.pratha;



// [4, 2, 0, 5, 0, 1, 3]
// 2+4+3+2 = 11
/*

leftMax = [4,4,4,5,5,5,5]
RightMax = [5,5,5,5,3,3,3]
input = [4,2,0,5,0,1,3]
for i=1:n
    sum += Min(leftMax[i],RighMax[i]) - input[i]

TimeComplexity = 0(n)
SpaceComplexity = 0(n)
*/

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class WaterHarvest {

    public int findHarvestedWaterUnits(int[] input){
        if(input == null){
            return -1;
        }

        int n = input.length;
        int[] leftMax =findLeftMax(input, n);
        int rightMax = input[n-1];
        int units = (Math.min(rightMax, leftMax[n-1]) - input[n-1]);
        printArray(leftMax,n);
        for(int i = n-2; i >= 0 ; i--){
            if(rightMax < input[i]){
                rightMax = input[i];
            }
            units = units+(Math.min(rightMax, leftMax[i]) - input[i]);
        }

        return units;
    }

    private int[] findLeftMax(int[] input, int n){
        int[] leftMax = new int[n];
        int currMax = input[0];
        leftMax[0] = input[0];
        for(int i = 0; i < n; i++){
            if(currMax < input[i]){
                currMax = input[i];
            }
            leftMax[i] = currMax;
        }

        return leftMax;
    }

    void printArray(int[] a, int n){
        for(int i = 0; i < n; i++){
            System.out.print(a[i]+",");
        }
        System.out.println("");
    }
    public static void main(String args[] ) throws Exception {
        WaterHarvest solution = new WaterHarvest();
        int[] input = {4,2,0,5,0,1,3};

        System.out.println(" output:"+solution.findHarvestedWaterUnits(input));
    }
}