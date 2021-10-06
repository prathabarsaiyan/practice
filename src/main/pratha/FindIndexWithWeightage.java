package main.pratha;

/**
 * Given an array of numbers, where i represents the model i and A[i] represents the percentage with which model ‘i’ should be called, write an api to take the array as input and return a random model id as per given array of percentages. For example:
 *
 * Input Array:
 * 66.123   .8877  23.234   1.766
 * 60 10 20 10
 *
 *
 * 0-60, 60-70, 70-90, 90-100
 *
 * Probable Output:
 * 2
 * 2
 * 1
 * 0
 * 3
 * 2
 * 1
 * 0
 * 0
 * 0.. so on
 *
 *
 *
 //0,60,70,90

 //random n =2

 //start =0, end = 3
 //mid = 1

 //start =0, end = 1
 //mid = 0

 //output = 0

 //n = 90
 //start =0, end = 3
 //mid = 1

 //output= 3


 //n = 82
 //start =0, end = 3
 //mid = 1

 //start =1, end = 3
 //mid = 2

 //start =2, end = 3
 //mid = 2

 //output=2


 //n =65
 //start =0, end = 3
 //mid = 1

 //start =1, end = 3
 //mid = 2

 //start =1, end = 2
 //mid = 1

 //output = 1

 */
public class FindIndexWithWeightage {

    Double[] weightRangeBounds;

    public void initiateWeights(double[] arr){
        int n = arr.length;
        weightRangeBounds = new Double[n];
        Double curr = 0d;
        for(int i = 0; i< n;i++ ){
            weightRangeBounds[i] = curr;
            curr = curr+arr[i];
        }
    }

    public void getResourceIndex(){
        if(weightRangeBounds == null){
            System.out.println("Initiate the weights first");
            return;
        }
//It will return random double between 0-100
        double n = (Math.random() * (100 - 0));//Math.random(0,100);
        System.out.println(findIndex(0, weightRangeBounds.length-1, n));
    }

    int findIndex( int start, int end, double n){
        if(start>=end){
            return end;
        }

        int mid = start+end/2;

        if(start == mid){
            return start;
        } else if(n == weightRangeBounds[mid]){
            return mid;
        } else if (n == weightRangeBounds[end]){
            return end;
        } else if(n> weightRangeBounds[start] && n<weightRangeBounds[mid]){
            return findIndex(start, mid,n);
        } else{
            return findIndex(mid, end, n);
        }
    }

}
