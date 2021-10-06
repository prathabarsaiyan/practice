package main.pratha;

/**
 *
 * Almost Palindrome
 *
 * A string is said to be PALINDROME  if reverse of the string is same as string.
 * For example:
 * bcb
 * abba
 * tacocat
 *
 * Almost palindrome is a string which if you remove at most one character from it, you will turn the string into a palindrome
 *
 * tacocats → true tacocat[s] → tacocat
 * racercar → true race[r]car → racecar or rac[e]rcar → racrcar
 * abccbca → true
 * kbbayak →  false
 *
 * abccbca
 *
 *  bccb
 *   ccbc
 *
 *
 * i = 0, j = n-1
 *
 * compare char at i to char at j
 *
 * boolean charRemoved = false;
 *
 * while(i< j)
 *     if(a[i] == a[j])
 *         i++; j--;
 *     else if (a[i+1] = a[j] && a[i] != a[j-1])
 *         if(charRemoved){
 *           return  false;
 *          }
 *       charRemoved = true;
 *       i++;
 *     }else if(a[i] == a[j-1]){
 *
 *      if(charRemoved){
 *           return  false;
 *          }
 *       charRemoved = true;
 *       j--;
 *     }

 * // kbbayak = false
 * //tacocats → true tacocat[s] → tacocat
 * //racercar → true race[r]car → racecar or rac[e]rcar → racrcar
 * //abccbca → true
 *
 * // true: -1
 * // false: -2
 */
public class AlmostPalindrome {

    boolean charRemoved = false;

    int isValidInput(String st, int i, int j){
        char[] a = st.toCharArray();
        while(i < j){
            if(a[i] == a[j]){
                i++; j--;
            } else if(i == j-1){
                return -1;
            } else if (a[i+1] == a[j] || a[i] == a[j-1]){
                if(charRemoved){
                    return  -2;
                }
                charRemoved = true;
                if(isValidInput(st,i+1,j) == -1) {
                    return i;
                }
                if (isValidInput(st,i,j-1) == -1){
                    return j;
                }
                return -2 ;
            } else {
                return -2;
            }
        }

        return -1;
    }
}
