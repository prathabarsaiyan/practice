package main.pratha;

// Given a string "abbacdde" delete adjacent duplicate pairs
// abbacddde
// aacde
// cde

//abbacdde
//aace
//ce

//abbacdde
//ce
// TimeComplexity : O(n)
// SpaceComplexity : O(n)
import java.util.*;

public class DeleteAdjacentDuplicates {

    public String deleteAdjacentDuplicates(String str){
        if(str == null || str.length() < 2){
            return str;
        }
        Stack<Character> stack = processAdjacentDuplicates(str);
        return stackToString(stack);
    }

    private Stack<Character> processAdjacentDuplicates(String str){
        Stack<Character> stack= new Stack<>();
        int n = str.length();
        stack.push(str.charAt(n-1));
        for(int i = n-2; i >= 0; i--){
            if(stack.empty() || stack.peek() != str.charAt(i)){
                stack.push(str.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack;
    }

    private String stackToString(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }


    public static void main(String args[] ) throws Exception {
        DeleteAdjacentDuplicates solution = new DeleteAdjacentDuplicates();
        System.out.println(" abbacdde:"+ solution.deleteAdjacentDuplicates("abbacdde"));
        System.out.println(" abbacddde:"+ solution.deleteAdjacentDuplicates("abbacddde"));
    }
}