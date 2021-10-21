package main.pratha;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 1 -
 * 2 - abc
 * 3 - def
 * 4 - ghi
 * 5 - jkl
 * 6 - mno
 * 7 - pqrs
 * 8 - tuv
 * 9 - wxyz
 *
 *
 * 2 - [a,b,c]
 * 23 - [ad, ae, af, bd, be, bf]
 */
public class KeypadText {


    public static void main(String[] args) {
        initialize();
        System.out.println(getKeypadOutputOptions("23"));
    }

    static HashMap<Character, List<Character>> characterListMap = new HashMap<>();

    static void initialize(){
        characterListMap.put('2', Arrays.asList('a', 'b', 'c'));
        characterListMap.put('3', Arrays.asList('d', 'e', 'f'));
        characterListMap.put('4', Arrays.asList('g', 'h', 'i'));
        characterListMap.put('5', Arrays.asList('j', 'k', 'l'));
        characterListMap.put('6', Arrays.asList('m', 'n', 'o'));
        characterListMap.put('7', Arrays.asList('p', 'q', 'r', 's'));
        characterListMap.put('8', Arrays.asList('t', 'u', 'v'));
        characterListMap.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    static List<String> getKeypadOutputOptions(String input){
        List<String> res = new ArrayList<>();
        res.add("");
        List<String> curr;
        for(char ch : input.toCharArray()){
            curr = new ArrayList<>();
            for(String s: res){
                for( char c: characterListMap.get(ch)){
                    curr.add(s+c);
                }
            }
            res = curr;
        }

        return res;
    }
}
