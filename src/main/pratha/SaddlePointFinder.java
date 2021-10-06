package main.pratha;

import java.util.*;

/*
Return a list of coordinates of every saddle point in a matrix of integers

Dimensions are rows and columns
A saddle point is a value that is a maximum in one dimension and a minimum in the other dimension

1, 4, 7
4, 5, 8  -> [ (0, 2), (2, 0) ]
7, 8, 9


map named "row_mins" row index -> index with minimum value
{{0,0},{1,0},{2,0}}

map named "row_maxes" row index -> index with max value
{{0,2},{1,2},{2,2}}

map named "col_mins" col index -> index with min value
{ (0, 0), (1,0), (2,0)}

map named "col_maxes" col index -> index with max value
{ (0, 2), (1, 2), (2, 2) }


*/


class SaddlePointFinder {
    public static void main(String[] args) {
        int[][] ar = {{1,4,7},{4,5,8},{7,8,9}};
        findSaddlePoint(ar);
    }

    private static void findSaddlePoint(int[][] ar){

        int m = ar.length;
        int n = ar[0].length;

        Map<Integer, Integer> rowMin = new HashMap<>();
        Map<Integer, Integer> rowMax = new HashMap<>();

        Map<Integer, Integer> colMin = new HashMap<>();
        Map<Integer, Integer> colMax = new HashMap<>();

        int min , max , minInd = 0, maxInd =0;

        for(int i = 0; i < m ; i++){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for(int j = 0; j< n; j++){
                if(min > ar[i][j]){
                    min = ar[i][j];
                    minInd = j;
                }
                if(max<ar[i][j]){
                    max = ar[i][j];
                    maxInd = j;
                }

            }
            rowMin.put(i,minInd);
            rowMax.put(i,maxInd);
        }

        for(int j = 0; j < n ; j++){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for(int i = 0; i< m; i++){
                if(min > ar[i][j]){
                    min = ar[i][j];
                    minInd = j;
                }
                if(max<ar[i][j]){
                    max = ar[i][j];
                    maxInd = j;
                }

            }
            colMin.put(j,minInd);
            colMax.put(j,maxInd);
        }

        System.out.println("Row Min");
        printMap(rowMin);
        //printMap(rowMax);
        //printMap(colMin);
        System.out.println("Col Max");
        printMap(colMax);

        for(Map.Entry<Integer, Integer> entry: rowMin.entrySet()){
            if(entry.getKey() == colMax.get(entry.getValue())){
                System.out.println(entry.getKey()+":"+entry.getValue());
            }
        }

    }

    static void printMap(Map<Integer, Integer> mp){
        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            System.out.print("\t"+entry.getKey()+":"+entry.getValue());
        }

    }
}
