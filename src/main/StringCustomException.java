package main;

import java.util.*;

public class StringCustomException {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String arr[] = new String[n];
        int i=0;
        while(i < n){
            arr[i++] = in.nextLine();
        }
        solve(arr);
    }
    static void solve(String arr[]){
        for(String str: arr){
            takeAction(str);
        }
        System.out.println("Exception checked.");
    }

    static void takeAction(String str){

        String[] split = str.split("==");

        String word =  split[1];

        if(split[0].equals("1")){
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            sb.reverse();
            try{
                if(!word.equals(sb.toString())){
                    throw new NotPalindromeException(sb.toString());
                }
                System.out.println(word);
            } catch(NotPalindromeException npe){
                // do nothing
            }
        } else if(split[0].equals("2")){
            //mid = 3
            int mid = word.length()/2;
            //
            String part1 = word.substring(0,mid);

            if(word.length() % 2 != 0){
                mid++;
            }

            String part2 = word.substring(mid);

            try{
                if(part1.equals(part2)){
                    throw new EqualException(part1);
                }
                System.out.println(word);
            } catch(EqualException npe){
                //do nothing
            }
        }

    }
}


class NotPalindromeException extends Exception{
    NotPalindromeException (String str){
        System.out.println("PalindromeException...");
        System.out.println(str);
    }
}

class EqualException extends Exception{
    EqualException (String str){
        System.out.println("EqualException...");
        System.out.println(str);
    }
}
