package main.pratha;

import java.util.Comparator;
import java.util.*;
import java.io.*;
import java.math.*;

public class PasswordChecker {

    /*
     * Implement method/function with name 'solve' below.
     * The function accepts following as parameters.
     *  1. k is of type int.
     *  2. ar is of type List<String>.
     *  3. str is of type String.
     * return List<Integer>.
     */

    public static List<Integer> solve(int k,List<String> ar,String str){
        ar.sort(Comparator.comparing(String::length));

        int i = 0, j;
        for(i = 0; i< ar.size();i++){
            if(ar.get(i).length() == str.length()){
                break;
            }
        }
        i++;
        for(j = i; j< ar.size();j++){
            if(ar.get(i).length() > str.length()){
                break;
            }
        }


//        j++;
        System.out.println(i +"::"+j);
        int min = ((i-1)/k * 5)+i;
        int max = ((j-1)/k * 5)+j;


//        int i =0;
//        int min,max;
//        for (String s: ar) {
//
//            if(s.length()==str.length() && min!=0) {
//                min=i;
//            }
//            if(s.length()>str.length()) {
//                max=i;
//            }
//            i++;
//        }
//        int n = ar.size();
//        int m = str.length();
//        int i = 0;
//        int sec = 1;
//        int min, max;
//
//        while(i < n && ar.get(i).length() > m ){
//            sec++;
//            if(i%k == 0){
//                sec+=k;
//            }
//            i++;
//        }
//        i++;
//        min = sec;
//        while( i < n && ar.get(i).length() == m){
//            sec++;
//            if(i%k == 0){
//                sec+=5;
//            }
//            i++;
//        }
//        max = sec;
//
        List<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        return res; //return type "List<Integer>".
    }

    public static void main(String[] args) {
        List<String> ar = new ArrayList<>();
        ar.add("abb");
        ar.add("baa");
        System.out.println(solve(1,ar, "baa"));

        List<String> ar1 = new ArrayList<>();
        ar1.add("cccc");
        ar1.add("a");
        ar1.add("baa");
        System.out.println(solve(2,ar1, "baa"));
    }

}