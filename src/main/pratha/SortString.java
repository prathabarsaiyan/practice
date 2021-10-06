package main.pratha;
import java.io.*;
import java.util.*;

/**
 * sort the string in an order of lexicographically
 * fist all lowerCase, then upperCase,then even digit and then odd digits
* */
class Result {
    /*
     * Complete the 'sort' function below.
     */
    public static String sort(final String input) {
        StringBuffer lowerCase = new StringBuffer();
        StringBuffer upperCase = new StringBuffer();
        StringBuffer evenNum = new StringBuffer();
        StringBuffer oddNum = new StringBuffer();

        for(char ch: input.toCharArray()){
            if(Character.isDigit(ch)){
                int a = Integer.parseInt(ch+"");
                if(a%2 == 0){
                    evenNum.append(ch);
                }else{
                    oddNum.append(ch);
                }
            }else if(Character.isUpperCase(ch)){
                upperCase.append(ch);
            }else{
                lowerCase.append(ch);
            }
        }

        String res = sortString(lowerCase.toString())
                + sortString(upperCase.toString())
                + sortString(evenNum.toString())
                + sortString(oddNum.toString());

        return res;
    }

    static String sortString(String str) {
        char []arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}

public class SortString {
    public static void main(String[] args) throws IOException {
        System.out.println(Result.sort("134BTSsfg"));


    }
}

