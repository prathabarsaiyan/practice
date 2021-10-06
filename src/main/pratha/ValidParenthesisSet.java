package main.pratha;

import java.util.*;

/**
 * generate valid Parenthesis Set for a given num
 *
 * input : 3
 *
 * outpur : ((())), (()()), (())(), ()(()), ()()()
 */
public class ValidParenthesisSet {

    public static List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
//        if(n == 0){
//             return Collections.emptyList();
//        }
//        List<String> result = new ArrayList<>();
//
//        if(n == 1){
//            result.add("()");
//            return result;
//        }
//
//        generateParenthesis("(",result,n,false);
//        return result;
    }

    private static void generateParenthesis(String prefix, List<String> result, int n, boolean close) {
        if(n <= 0){
            if(close) {
                result.add(prefix + ")");
            }
        }else {
            generateParenthesis(prefix + ")", result, n - 1, !close);
            generateParenthesis(prefix + "(", result, n-1, close);
        }
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
