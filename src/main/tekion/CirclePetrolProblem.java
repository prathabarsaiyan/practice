package main.tekion;

/**
 * Spurthi Gouthareddy to Everyone (2:04 PM)
 * Suppose there is a circle. There are n petrol pumps on that circle. You are given two sets of data.
 * 1. The amount of petrol that every petrol pump has.
 * 2. Distance from that petrol pump to the next petrol pump.
 * Calculate the first point from where a truck will be able to complete the circle
 * (The truck will stop at each petrol pump and it has infinite capacity).
 * Expected time complexity is O(n).
 * Assume for 1-litre petrol, the truck can go 1 unit of distance.
 * For example, let there be 4 petrol pumps with amount of petrol and distance to next petrol pump value pairs
 * as {4, 6}, {6, 5}, {7, 3} and {4, 5}.
 * The first point from where the truck can make a circular tour is 2nd petrol pump.
 * Output should be “start = 1” (index of 2nd petrol pump).
 */

public class CirclePetrolProblem {

    public static void main(String[] args) {
        int[] petrol = {4,6,7,4};
        int[] distance = {6,5,3,5};
        System.out.println(findStartIndex(petrol,distance));

        int[] petrol1 = {4,6,1,4};
        int[] distance1 = {6,5,3,5};
        System.out.println(findStartIndex(petrol1,distance1));
    }

    private static int findStartIndex(int[] petrol, int[] distance) {
        if(petrol == null || distance == null
                || petrol.length == 0 || distance.length == 0
                || petrol.length != distance.length
                || !isSolutionPossible(petrol, distance)){
            return -1;
        }

        int currFill = 0, i = 0, start = 0;
        int n = petrol.length;
        int visited = 0;
        while(visited < n){
            while(currFill >=0) {
                if (visited == n) {
                    return start;
                }
                currFill = currFill + petrol[i] - distance[i];
                visited++;
                i++;
                if (i == n) {
                    i = 0;
                }
            }
            visited = 0;
            start = i;
            currFill = 0;
        }
        return start;
    }

    private static boolean isSolutionPossible(int[] petrol, int[] distance) {
        int totalPetrol = 0;
        int totalDistance = 0;
        for(int i =0; i< petrol.length;i++){
            totalPetrol+=petrol[i];
            totalDistance+=distance[i];
        }
        return totalPetrol >= totalDistance;
    }
}
