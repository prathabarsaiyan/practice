package main;

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
