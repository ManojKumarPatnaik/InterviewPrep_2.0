package Amazon;

import java.util.ArrayList;
import java.util.List;

public class CarPooling {

    class Destination {

        int point;
        int capacity;
    }

    public boolean carPooling1(int[][] trips, int capacity) {

        //1. separate the start and end destination
        List<Destination> startDestination = new ArrayList<>();
        List<Destination> endDestination = new ArrayList<>();

        for(int i=0; i< trips.length; i++) {

            int seatOccupied = trips[i][0];
            int startPoint = trips[i][1];
            int endPoint = trips[i][2];

            Destination startPointObj = new Destination();
            startPointObj.point = startPoint;
            startPointObj.capacity = seatOccupied;

            Destination endPointObj = new Destination();
            endPointObj.point = endPoint;
            endPointObj.capacity = seatOccupied;

            startDestination.add(startPointObj);
            endDestination.add(endPointObj);

        }

        //sort both the list based on point
        startDestination.sort((A,B) -> A.point - B.point);
        endDestination.sort((A,B) -> A.point - B.point);

        int startPointer = 0;
        int endPointer = 0;
        int freeSeats = capacity;
        while (startPointer < startDestination.size()) {

            if(startDestination.get(startPointer).point < endDestination.get(endPointer).point) {

                if(freeSeats >=  startDestination.get(startPointer).capacity) {
                    freeSeats = freeSeats - startDestination.get(startPointer).capacity;
                } else {
                    return false;
                }
                startPointer++;
            }  else {

                freeSeats = freeSeats + endDestination.get(endPointer).capacity;
                endPointer++;
            }
        }

        return true;

    }

     boolean carPooling(int[][] trips, int capacity) {
        int maxLocationPoint = 0;
        int[] locationPoints = new int[1001];

        for(int[] trip : trips){
            int startPoint = trip[1];
            int endPoint = trip[2];
            maxLocationPoint = Math.max(endPoint,maxLocationPoint);
            locationPoints[startPoint] += trip[0];
            locationPoints[endPoint] -= trip[0];
        }

        for(int i = 1; i <= maxLocationPoint; i++) {
            locationPoints[i] += locationPoints[i - 1];
        }

        for(int i = 0; i < maxLocationPoint; i++) {
            if(locationPoints[i]>capacity) return false;
        }

        return true;
    }


    public static void main(String args[]) {

        int capacity = 5;
        int[][] trips = {{2,1,5} ,{3,3,7}};
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPooling(trips, capacity));
    }
}
