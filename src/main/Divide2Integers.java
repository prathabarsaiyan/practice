package main;

public class Divide2Integers {

    public static int divide(int dividend, int divisor) {
        if(dividend == divisor){
            return 1;
        }
        int d1 = dividend;
        int d2 = divisor;
        boolean signed = false;
        if(d1 < 0 ){
            if(d1 ==-2147483648){
                d1 = 2147483647;
            }else{
                d1 = -1 * d1;
            }
            if(divisor >= 0){
                signed = true;
            }
        }
        if (d2 < 0){
            d2 = -1 * d2;
            if(dividend >= 0){
                signed = true;
            }
        }

        if(d2 == 1){
            return (signed ? (-1*d1) : d1);
        }

        int sum = d2;
        int count = 0;
        while(sum <= d1){
            sum +=d2;
            count++;
        }

        return (signed ? (-1*count) : count);
    }

    public static void main(String[] args) {
//        System.out.println(divide(2,3));
//        System.out.println(divide(10,10));
//        System.out.println(divide(10,3));
        System.out.println(divide(-2147483648,1));
    }
}
