package main.pratha;

import java.util.*;
/**
 * Find free slots from schedules of N resources.
 * Assume inputs are in unix timestamps.
 *
 *
 * [
 * [ [1, 2],  [5, 6] ],
 * [ [1  ,3],[4,5],   [8,9] ],
 * ]
 * start - 1
 * end - 10
 *
 * [ [3, 4], [6, 8] [9, 10] ]
 *
 *
 * [
 * [ [1, 200],  [500000, 600000] ],
 * [ [1  ,3],[40000,50000],   [8000000,900000] ],
 * ]
 *
 *
 * start - 1
 * end - 10000000
 */
class Slot {
    long start;
    long end;

    Slot(long start, long end){
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString(){
        return Long.toString(start)+","+Long.toString(end);
    }
}
public class FindResourceAvailableSlot {

    static List<Slot> getAvailableSlot(List<List<Slot>> resourceSlotList){
        List<Slot> slotList = new ArrayList<>();
        for(List<Slot> sl: resourceSlotList){
            for(Slot slot: sl){
                updateSlotList(slotList, slot);
            }
        }
        return slotList;
    }

    static void updateSlotList(List<Slot> slotList, Slot slot){
        for(int i = 0; i< slotList.size(); i++){
            Slot sl =  slotList.get(i);
            //if the range is within what is already in the list
            if(slot.start > sl.end){
                continue;
            }
            else if(sl.start<= slot.start && sl.end >=slot.end){
                return;
            }
            else if(slot.end < sl.start){
                slotList.add(i,slot);
                return;
            }
            //if the start is there but the end is greater than what is present
            else if(sl.start <= slot.start && sl.end < slot.end){
                sl.end = slot.end;
                return;
            }
            //if the start is there but the start is lesser than what is present and end is lesser
            else if (sl.start > sl.start && slot.end <= sl.end){
                sl.start = slot.start;
                return;
            }

            else if( i < slotList.size()-1 && sl.start > slot.end && sl.end < slotList.get(i+1).start){
                slotList.add(i+1,slot);
                return;
            }
        }
        slotList.add(slot);
    }
    public static void main(String[] args) {
        Slot r1_s1 = new Slot(1,2);
        Slot r1_s2 = new Slot(5,6);

        List<Slot> r1 = new ArrayList<>();
        r1.add(r1_s1);
        r1.add(r1_s2);

        Slot r2_s1 = new Slot(1,3);
        Slot r2_s2 = new Slot(4,5);
        Slot r2_s3 = new Slot(8,9);
        List<Slot> r2 = new ArrayList<>();
        r2.add(r2_s1);
        r2.add(r2_s2);
        r2.add(r2_s3);

        List<List<Slot>> input = new ArrayList<>();
        input.add(r1);
        input.add(r2);
        System.out.println(getAvailableSlot(input));
    }
}
