package main.pratha;


/**
 * determine weather a number is pow of 2
 */
public class isPowOf2 {

    //Assumption n > 0
    public static boolean powOf2(int n){
        if(n == 0){
            return false;
        }

        while(n > 1){
            if(n%2 != 0){
                return false;
            }
            n = n/2;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(powOf2(1048));
    }

}
