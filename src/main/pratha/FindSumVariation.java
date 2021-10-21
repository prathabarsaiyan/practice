package main.pratha;

import java.util.*;

public class FindSumVariation {

    public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {
        List<Long> res = new ArrayList<>();

        List<Long> sumTill = new ArrayList<>();
        List<Integer> zeroTill = new ArrayList<>();
        sumTill.add(0l);
        zeroTill.add(0);
        int zeroCount = 0;
        long currSum = 0;
        for(int n: numbers){
            currSum+=n;
            sumTill.add(currSum);
            if(n == 0){
                zeroCount++;
            }
            zeroTill.add(zeroCount);
        }

        for(List<Integer> q: queries){
            int l = q.get(0)-1;
            int r = q.get(1);
            int x = q.get(2);

            long sum = sumTill.get(r) - sumTill.get(l) + x * (zeroTill.get(r) - zeroTill.get(l));

            res.add(sum);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(-5);
        a.add(0);

        List<List<Integer>> b = new ArrayList<>();
        List<Integer> b1 = new ArrayList<>();
        List<Integer> b2 = new ArrayList<>();

        b1.add(2);
        b1.add(2);
        b1.add(20);

        b2.add(1);
        b2.add(2);
        b2.add(10);

        b.add(b1);
        b.add(b2);

        System.out.println(findSum(a, b));

    }
}