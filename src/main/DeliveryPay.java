package main;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DeliveryPay {


    /*
        startTime, endTime, deliveryStartingTimes, deliveryEndTimes, deliveryPay

        0,
        10,
        [2, 5, 8, 2]
        [6, 8, 10, 5]
        [5, 2, 3, 4]

        [0,0,0,0,4, 5, 0, 6,0,9]
        max ( n-1 || max(starttime) + currentPay)

        9
        2-5 -> 4
        5-8 -> 2
        8-10 -> 3

        0,
        10,
        [2, 5, 5, 8, 2]
        [5, 6, 8, 10, 5]
        [5, 2, 10, 3, 4]


        0,
        10,
        [2, 5, 6, 7, 5] [4]
        [5, 6, 7, 8, 10] [5]
        [5, 3, 4, 3, 9] [6]

        [2, 2, 4, 3]
        [4, 5, 5, 6]
        [3, 5, 3, 5]

        [0,0,5,5,5,14,14,14,14,14,14] = 14
        [0,0,5,5,5,3,4,3,0,0] = 15


        [,10,7,3,0,0]

        4 -> 5 = 3 ?

        3 -> 6 = 5?
        [0, 0, 0, 0, 3, 6, 6, ]
         [0.  1. 2. 3. 4. 5. 6, ]
    */

//    static int getMaxDeliveryPay(int startTime, int endTime, int[] deliveryStartingTimes, int[] deliveryEndTimes, int[] deliveryPay){
//        if(startTime > endTime
//                || deliveryStartingTimes == null
//                || deliveryEndTimes == null
//                || deliveryPay == null
//                || deliveryStartingTimes.length == 0
//                || deliveryStartingTimes.length != deliveryEndTimes.length
//                || deliveryStartingTimes.length != deliveryPay.length){
//            return 0;
//        }
//
//        int n = deliveryEndTimes.length;
//        int max = Integer.MIN_VALUE;
//
//        List<TimeSlot> timeSlots = new ArrayList<>();
//        for(int i = 0; i< n;i++){
//            timeSlots.add(new TimeSlot(deliveryStartingTimes[i],deliveryEndTimes[i],deliveryPay[i]));
//        }
//        Collections.sort(timeSlots);
//        //System.out.println(timeSlots);
//        // List<Integer> skippedList = new ArrayList<>();;
//        Set<Integer> timeSlots;
//        int currPay = 0;
//        for(int i = 0; i< n; i++){
//            timeSlots = initiateTimeSlots(startTime, endTime);
//            boolean timeSlotBooked = false;
//            for(int time = deliveryStartingTimes[i]; time <= deliveryEndTimes[i]; time++){
//                if(timeSlots.contains(time)){
//                    timeSlotBooked = true;
//                    break;
//                }
//            }
//            if(timeSlotBooked){
//                skippedList.add(i);
//            } else {
//                currPay+=deliveryPay[i];
//            }
//
//
//            return max;
//        }
//
//        static Set<Integer> initiateTimeSlots(int startTime, int endTime){
//            Set<Integer> timeSlots = new HashSet<>();
//            for(int i = startTime; i <= endTime; i++){
//                timeSlots.add(i);
//            }
//
//            return timeSlots;
//        }
//        static class TimeSlot implements Comparable<TimeSlot>{
//            int startTime;
//            int endTime;
//            int pay;
//
//            TimeSlot(int startTime, int endTime, int pay){
//                this.startTime = startTime;
//                this.endTime = endTime;
//                this.pay = pay;
//            }
//
//            public int compareTo(TimeSlot slot){
//                if(slot.startTime == this.startTime){
//                    if(slot.pay > this.pay){
//                        return 1;
//                    }else{
//                        return -1;
//                    }
//                }else if(slot.startTime < this.startTime){
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//
//            public String toString(){
//                return "Start time : "+startTime+" :: endTime : "+endTime+" :: pay : "+pay;
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] deliveryStartingTimes ={2,5,8,2} ;
//            int[] deliveryEndTimes = {6,8,10,5};
//            int[] deliveryPay = {5,2,3,4};
//            System.out.println(getMaxDeliveryPay(0,10, deliveryStartingTimes, deliveryEndTimes,deliveryPay));
//        }
    }
