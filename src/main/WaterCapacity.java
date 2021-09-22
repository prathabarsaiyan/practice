package main;

import java.util.*;

public class WaterCapacity {

    public static void main(String[] args) {

        int[] capacity = {7, 1, 5, 4, 2, 4};
        int[] water = {3, 1, 4, 4, 1, 2};

        final WaterCapacity wc = new WaterCapacity();
        System.out.println(wc.solve(capacity, water));
        //output -> 3
        // 7 + 5 + 4 can carry full capacity.
    }

    private int solve(final int[] capacity, final int[] water) {

        int totalWater = 0;
        for(int i = 0; i< water.length; i++){
            totalWater+=water[i];
        }

        Arrays.sort(capacity);
        int count = 0;
        for(int i = capacity.length-1; i>=0 && totalWater >=0; i--){
            if(totalWater == 0){
                return count;
            }
            count++;
            totalWater = totalWater - capacity[i];
        }
        return count;
    }

}
