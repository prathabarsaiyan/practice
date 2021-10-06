package main.pratha;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Longest non-repetitive substring
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length()==0){
            return 0;
        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        int max = 1;
//        int curr = 1;
//        map.put(s.charAt(0),0);
//
//        for(int i = 1; i<s.length();i++){
//            char ch = s.charAt(i);
//            if(map.containsKey(ch)){
//                max = Math.max(curr, max);
//                curr = i-map.get(ch);
//            }else{
//                curr++;
//            }
//            map.put(ch, i);
//        }
//        max = Math.max(curr, max);
//        return max;

        int n = s.length();
        int res = 0;
        int [] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int i = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);

            res = Math.max(res, j - i + 1);

            lastIndex[s.charAt(j)] = j;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("abcabcbb:" + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb:" + lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew:" + lengthOfLongestSubstring("pwwkew"));
        System.out.println("dvdf:" + lengthOfLongestSubstring("dvdf"));
        System.out.println("cdd:"+lengthOfLongestSubstring("cdd"));
        System.out.println("au:"+lengthOfLongestSubstring("au"));
        System.out.println("null:"+lengthOfLongestSubstring(null));
        System.out.println("abba:"+lengthOfLongestSubstring("abba"));
    }
}
