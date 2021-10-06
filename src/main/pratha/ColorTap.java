package main.pratha;

import java.util.Stack;


/**
 * Given a string "RRRBBGBBBGG" delete adjacent duplicate pairs
 * // RGB
 *
 * Remove adjacentDuplicate colors
 */
public class ColorTap {

    String getTapResult(String input){
        if(input == null || input.length()<2){
            return input;
        }
        int n = input.length();
        Stack<Character> st = new Stack<>();
        st.push(input.charAt(0));
        int i = 1;
        while(i < n){
            if(!st.empty() && st.peek() == input.charAt(i)){
                st.pop();
            } else {
                st.push(input.charAt(i));
            }
            i++;
        }

        StringBuilder out = new StringBuilder();
        while(!st.empty()){
            out.append(st.pop());
        }

        return out.toString();

    }

}
