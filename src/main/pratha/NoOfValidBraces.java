package main.pratha;

/**
 * return number of valid combinations of brackets
 *
 * 1 - {}  - 1
 * 2 - {}{}, {{}} - 2
 * 3 - {}{}{}, {{}{}}, {}{{}},  {{}}{},  {{{}}} - 5
 *
 *
 * It can be solved via recursion as well
 * just add {} at starting, end and in enclosure to the previous int result
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
