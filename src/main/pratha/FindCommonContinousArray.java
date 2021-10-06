package main.pratha;

import java.util.*;
/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/
", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
findContiguousHistory(user2, user1) => ["a"]
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history

*/

public class FindCommonContinousArray {
    public static void main(String[] argv) {

        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red","a" };
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber"};

        System.out.println(findContiguousHistory(user0,user1));
        System.out.println(findContiguousHistory(user0, user2));
        System.out.println(findContiguousHistory(user0, user0));
        System.out.println(findContiguousHistory(user2, user1));
        System.out.println(findContiguousHistory(user5, user2));
        System.out.println(findContiguousHistory(user3, user4));
        System.out.println(findContiguousHistory(user4, user3));
        System.out.println(findContiguousHistory(user3, user6));
    }


    static List<String> findContiguousHistory(String[] userA, String[] userB){
        List<String> list = new ArrayList<>();
        int currCount =0;
        int max = 0;
        int m = userA.length;
        int n = userB.length;
        int i =0,j=0;
        boolean resetI = false;

        while(i < m && j < n) {
            while(i < m && j < n && userA[i].equals(userB[j]) ){
                currCount++;
                i++;
                j++;
                resetI = true;
            }

            if(max < currCount){
                list = addElementToList(userB, j-currCount, j);
                max = currCount;
            }

            if(resetI){
                //System.out.println("Inside reset I "+i);
                i = 0;
                resetI = false;
            } else {
                //System.out.println("Increasing i "+i);
                i++;
                if(i == m && j < n){
                    //System.out.println("resetting i "+i+" and increasing j:"+j);
                    i =0;
                    j++;
                }
            }

            //System.out.println("currCount "+currCount);

            currCount = 0;
        }

        return list;
    }

    private static List<String> addElementToList(String[] arr, int startInd, int endInd){
        //System.out.println("Call in addElementToList::"+" startInd::"+startInd+"  endInd:"+endInd);
        List<String> array = new ArrayList<>();

        for(int i = startInd ; i < endInd; i++){
            array.add(arr[i]);
        }

        return array;
    }

}