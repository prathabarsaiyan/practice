package main.pratha;


import java.util.*;
/**
 * a = [11,22,7,7,7,7,7,7,7,22,13]
 *        0   1  2,3,4,5,6,7,8, 9, 10
 *
 * Ith index:
 * i + 1
 * i - 1
 * Jth index, where: arr[i] = arr[j]
 *
 * Output:
 * No of movements: 3
 * Path : 11->22->22->13
 *
 * Count = 3
 * 11->22->22->13
 *
 *
 * 11, 0
 * 22, 9
 * 7, 8
 * 13,10
 *
 * a = [11,22,7,7,7,7,7,7,7,22,7,7,7,7,13]
 *
 * 11 0
 * 22 1
 * 7 2
 * 13 10
 *
 *
 * Output1 = 11->22->22->7->7->13
 * Count1 = 5
 *
 * Output2 = 11->22>7->7->13
 * Count2 = 4
 *
 * 11, 0
 * 22, 1
 * 7, 2
 * 13,10
 *
 *
 *
 *
 *
 * [100,-23,-23,404,100,23,23,23,3,404]
 *    0,      1,  2,    3,     4,   5,  6,  7, 8 , 9
 *
 * 100, 0
 * -23, 1
 * 404, 2
 * 23, 5,
 * 3,8
 *
 *
 * Output = 100 -> -23 -> -23 -> 404 -> 404
 * count= 4;
 *
 * Count = 3
 * 100-> 100->404->404
 */


public class ShortestDistanceInArray {

    Map getIndexMap(int[] arr, int n){
        Map<Integer, Integer> indexMap = new HashMap<>();
        n = arr.length;
        for(int i = 0; i< n;i++){
            if(!indexMap.containsKey(arr[i])){
                indexMap.put(arr[i], i);
            }
        }
        return indexMap;
    }

    void printPathAndCount(int[] arr){
        //Validations 
        int n = arr.length;

        Map<Integer, Integer> indexMap = getIndexMap(arr,n);
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[n-1]);
        int i = n-1;

        //todo:: not finished, condition is wrong
        int min = 0;
        while( i > 0 ){
            if(i == n-1){
                i = min;//check i-1,//check equal Value)
            } else{
                i = min;//check value in map   i-1, //check value in map i+1,//check equal Value)
            }
            stack.push(arr[i]);
        }

        int count = 0;
        System.out.print(stack.pop());

        while(!stack.empty()){
            count++;
            System.out.print("->"+stack.pop());
        }
        System.out.println("");
        System.out.println(count);

    }
}
