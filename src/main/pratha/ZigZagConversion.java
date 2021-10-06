package main.pratha;

/**
 * Print Concatenation of Zig-Zag String in ‘n’ Rows
 *
 * Given a string and number of rows ‘n’. Print the string formed by concatenating n rows when input string is written in row-wise Zig-Zag fashion.
 *
 * Examples:
 *
 * Input: str = "ABCDEFGH"
 *        n = 2
 * Output: "ACEGBDFH"
 * Explanation: Let us write input string in Zig-Zag fashion
 *              in 2 rows.
 * A   C   E   G
 *   B   D   F   H
 * Now concatenate the two rows and ignore spaces
 * in every row. We get "ACEGBDFH"
 *
 * Input: str = "GEEKSFORGEEKS"
 *        n = 3
 * Output: GSGSEKFREKEOE
 * Explanation: Let us write input string in Zig-Zag fashion
 *              in 3 rows.
 * G       S       G       S
 *   E   K   F   R   E   K
 *     E       O       E
 * Now concatenate the two rows and ignore spaces
 * in every row. We get "GSGSEKFREKEOE"
 */
public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows < 2 || s.length()<numRows){
            return s;
        }
        boolean zig = false;
        int count = 1;
        int size = s.length();
        char ch[][] = new char[numRows][size];
        int m = 0, n = 0;

        for(int i = 0; i< size ; i++){
            ch[m][n] = s.charAt(i);
            if(zig){
                m--;
                n++;
            } else {
                m++;
            }
            count++;
            if(count == numRows){
                count = 1;
                zig = !zig;
            }
        }

        String res = "";
        for(int i = 0; i< numRows;i++){
            for(int j = 0; j < (size/numRows+numRows); j++){
                if(ch[i][j] != '\u0000'){
                    res+=ch[i][j];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3).equals( "PAHNAPLSIIGYIR"));
        System.out.println(convert("PAYPALISHIRING",4).equals( "PINALSIGYAHRPI"));
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
                3));
        System.out.println(convert("AB",1).equals( "AB"));
    }
}
