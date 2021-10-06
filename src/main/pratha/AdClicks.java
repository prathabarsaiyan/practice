package main.pratha;

/*
The people who buy ads on our network don't have enough data about how ads are working for their business. They've asked us to find out which ads produce the most purchases on their website.

Our client provided us with a list of user IDs of customers who bought something on a landing page after clicking one of their ads:

# Each user completed 1 purchase.
completed_purchase_user_ids = [
	"3123122444","234111110", "8321125440", "99911063"]

And our ops team provided us with some raw log data from our ad server showing every time a user clicked on one of our ads:

ad_clicks = [
	#"IP_Address,Time,Ad_Text",
	"122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
	"96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
	"122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
	"82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
	"92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
	"122.121.0.155,2017-01-01 03:18:55,Buy wool coats for your pets",
	"92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens",
]

The client also sent over the IP addresses of all their users.

all_user_ips = [
	#"User_ID,IP_Address",
	"2339985511,122.121.0.155",
	"234111110,122.121.0.1",
	"3123122444,92.130.6.145",
	"39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
	"8321125440,82.1.106.8",
	"99911063,92.130.6.144"
]

Write a function to parse this data, determine how many times each ad was clicked, then return the ad text, that ad's number of clicks, and how many of those ad clicks were from users who made a purchase.


Expected output:

1 of 2	 2017 Pet Mittens
0 of 1	 The Best Hollywood Coats
3 of 4	 Buy wool coats for your pets

purchases: number of purchase IDs
clicks: number of ad clicks
ips: number of IP addresses



*/

import java.io.*;
import java.util.*;

public class AdClicks {
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
