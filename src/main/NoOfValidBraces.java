package main;

/**
 * return number of valid combinations of brackets
 */
public class NoOfValidBraces {

    static double getTotalNoOfValueComboOfBraces(int n){
        return (Math.pow(2,n)-n);
    }

    public static void main(String[] args) {
        System.out.println("1 : "+getTotalNoOfValueComboOfBraces(1));
        System.out.println("2 : "+getTotalNoOfValueComboOfBraces(2));
        System.out.println("3 : "+getTotalNoOfValueComboOfBraces(3));
        System.out.println("4 : "+getTotalNoOfValueComboOfBraces(4));
    }

}
