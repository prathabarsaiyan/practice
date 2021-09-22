package main;

public class CircularRoad {
    //Circular road,
//Petrol pump - limited to petrol
//[1,5,5]

// petrol required to A-B - given
       // [5,5,1]



    int getStartPoint(int[] petrol, int[] costInPetrol){


        int i = 0, n = petrol.length;
        int currPetrol = 0;
        int visited = 0;
        int start = -1;

        while(i < n && start < n){
            currPetrol = currPetrol+petrol[i] - costInPetrol[i];

            if(i == n-1){
                i = 0;
            } else {
                i++;
            }

            if(currPetrol < -1){
                start = i;
                visited = 0;
                currPetrol = 0;
            }

            visited++;

            if(visited == n){
                return start;
            }
        }

        return visited != n ? -1 : start;
    }
}
