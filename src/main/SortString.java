package main;


import java.io.*;
import java.util.*;

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
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String input = bufferedReader.readLine();
        bufferedReader.close();

        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        final String result = Result.sort(input);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();

    }
}

