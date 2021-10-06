package main.pratha;

import java.util.*;

/*
 * Complete the 'getDNAAfterReaction' function below.
 *
 * The function is expected to return a STRING.
 */

// aAAbBCbBcCc -> space O(1) time O()
// ACc
// A

// M = 6
// AAAaaa o(n)
// AAaa  o(n-2)
// Aa o(n-4)
// space: O(1) time: O(N^2)

// Stack
// aAAbBCbBcCc
//  A
// space O(N) time complexity O(N)
public class DeleteAdjacentReactiveCharacters {
    public static void main(String[] args){
        String input = "aAAbBCbBcCcaaaB";
        System.out.println(getDNAAfterReaction(input));
    }

    public static String getDNAAfterReaction(String inputString) {
        if(inputString == null || inputString.length() < 2){
            return inputString;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(inputString.charAt(0));
        for(int i = 1; i< inputString.length();i++){
            if(stack.empty() || !checkIfReactive(stack.peek(), inputString.charAt(i))){
                stack.push(inputString.charAt(i));
            }else{
                stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    static boolean checkIfReactive(char ch1, char ch2){
        if((Character.isUpperCase(ch1) && Character.isUpperCase(ch2))
                || (Character.isLowerCase(ch1) && Character.isLowerCase(ch2))){
            return false;
        }

        if((""+ch1).equalsIgnoreCase(""+ch2)){
            return true;
        }

        return false;
    }
}
