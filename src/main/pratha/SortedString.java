package main.pratha;

import java.util.*;

/*
 *
   array = {"Apple", "Banana" "Mango"}
   Dictionary Sorted
   compareTo compareIgnoreCase
 */

public class SortedString {
        public static void main(String[] args) {
            ArrayList<String> strings = new ArrayList<String>();

            strings.add("Apple");
            strings.add("Apple");
            strings.add("Banana");
            strings.add("Mango");

            System.out.println(isSorted(strings));

        }

        static boolean isSorted(List<String> input){
            if(input == null || input.size() < 2){
                return true;
            }
            int n = input.size();
            for(int i = 1; i < n; i++){
                if(isGreater(input.get(i-1), input.get(i))){
                    return false;
                }
            }
            return true;
        }

        static boolean isGreater(String s1, String s2){
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            if(s1.equals(s2)) {
                return false;
            }

            int m = s1.length();
            int n = s2.length();
            int i = 0;

            while(i < m && i< n){
                if(s1.charAt(i) < s2.charAt(i)) {
                    return false;
                } else if(s1.charAt(i) > s2.charAt(i)) {
                    return true;
                }
                i++;
            }

            return true;
        }
    }


