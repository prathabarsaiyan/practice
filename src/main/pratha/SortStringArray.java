package main.pratha;

// // what is problem in this code ??

// public static class CodeReview2 {
//     private String name;

//     CodeReview2(String name) {
//         this.name = name;
//     }

//     @Override
//     public boolean equals(Object o) {
//         if (this == o) return true;
//         if (o == null || getClass() != o.getClass()) return false;

//         CodeReview2 boat = (CodeReview2) o;

//         return !(name != null ? !name.equals(boat.name) : boat.name != null);
//     }

//     @Override
//     public int hashCode() {
//         return (int) (Math.random() * 5000);
//     }
// }

// /**
// p1:  static class can only be nested class
// p2:  no 2 public class is allowed on a single file, file name should be same as public class
// p3:  why is the class static? If we need to create public class, we can make it non-static with static variable and methods.
// p4: if static variable/class is there, we dont need to override equals and hashcode, as    the the variable is shared across all the instances of the class
// p5:  hashCode method will return random values not on the basis of name
// */





// // Question 2

// // what is this code doing

// public void myfunction(int[] nums) {
//         int i = 0;
//         int j = 0;
//         while(i<nums.length){
//             if(i > 0 && nums[i] != 0 && j > 0){
//                 nums[i-j] = nums[i];
//                 nums[i] = 0;
//             }else if(nums[i] == 0){
//                 j++;
//             }
//             i++;
//         }
// }

/*Dry run for nums = [1,2,8,0,9]
 i=0 [1,2,8,0,9] j =0
  i++;

 i=1  [1,2,8,0,9] j =0
  i++;

 i=2  [1,2,8,0,9] j =0
  i++;

 i=3  [1,2,8,0,9] j=0
  j++;
  i++;

 i=4  [1,2,8,0,9] j=1
  [1,2,8,9,0]
  i++;

  output = [1,2,8,9,0]
*/



// Code Review

/*

class VendingMachine {
  public void VendingMachine() {

  }

  public int[] getCoinsForChange(int change) {
    List<Integer> coins = new ArrayList<>();
    change = addCoins(change, 25, coins);
    change = addCoins(change, 10, coins);
    change = addCoins(change, 5, coins);
    change = addCoins(change, 1, coins);

    return coins.stream().mapToInt(i -> i)f.toArray();
  }

  private int addCoins(int change, int denomination, List<Integer> coins) {
   while (change >= denomination) {
     change -= denomination;
     coins.add(denomination);
    }
    return change;
  }
}

*/

// class Solution {
//   public static void main (String[] args) {
//     VendingMachine vm = new VendingMachine();

//     int[] coins = vm.getCoinsForChange(83);

//     System.out.println(Arrays.toString(coins));
//   }
// }

// class VendingMachine {
//   //not required
//   public void VendingMachine() {

//   }

//   //Make denomination constants
//   public int[] getCoinsForChange(int change) {
//     List<Integer> coins = new ArrayList<>();

//     change = addCoins(change, 25, coins);
//     change = addCoins(change, 10, coins);
//     change = addCoins(change, 5, coins);
//     change = addCoins(change, 1, coins);

//     //we can directly call the method to array as well
//     return coins.stream().mapToInt(i -> i).toArray();
//   }

//   private int addCoins(int change, int denomination, List<Integer> coins) {
//    while (change >= denomination) {
//      change -= denomination;
//      coins.add(denomination);
//     }
//     return change;
//   }
// }




// // Question3 :

// // how to improve this code where i can give input on Sort type and i can even type "Am"
// // in case if we have to sort with millions of records what can be done.

// import java.util.Arrays;
// public class SortStringArrayExample1
// {
//   public static void main(String args[]){
//     String[] countries = {"Zimbabwe", "South-Africa", "India", "America", "Yugoslavia", " Australia", "Denmark", "France", "Netherlands", "Italy", "Germany"};
//     int size = countries.length;

//     for(int i = 0; i<size-1; i++) {
//       for (int j = i+1; j<countries.length; j++){
//           if(countries[i].compareTo(countries[j])>0) {
//             String temp = countries[i];
//             countries[i] = countries[j];
//             countries[j] = temp;
//           }
//       }
//     }
//     System.out.println(Arrays.toString(countries));
//   }
// }

// how to improve this code where i can give input on Sort type and i can even type "Am"
// in case if we have to sort with 10000 of records what can be done.


//Sorting should be performed using Order and Filter
//the filter Type support can be increased later on as well
//initially we can support, startsWith and length

// if the filter is provided, first run filter, then sort it


// if we have millions of records, then stream it and filter it
// while streaming, use insertion sort to sort the result of the filter


/**
 Trie data structure

 root

 a        b           c ................................. z
 n
 d-EOW
 */

import java.util.Arrays;
public class SortStringArray {

    public static void main(String args[]){
        String[] countries = {"Zimbabwe", "South-Africa", "India", "America", "Yugoslavia", " Australia", "Denmark", "France", "Netherlands", "Italy", "Germany"};
        int size = countries.length;

        for(int i = 0; i<size-1; i++) {
            for (int j = i+1; j<countries.length; j++){
                if(countries[i].compareTo(countries[j])>0) {
                    String temp = countries[i];
                    countries[i] = countries[j];
                    countries[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(countries));
    }

}



