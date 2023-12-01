package Uber;

/*
Uber has several cabs. The ith cab takes cabTripTime[i] minutes to complete any trip. Your task is to find the minimum time it will take Uber to get n trips completed with these cabs. You can assume that there is no waiting time in-between the trips.

Note: Different cabs can take the trips simultaneously (at any time, there can be more than one cab with an ongoing trip)

Example

    For n = 3 and cabTripTime = [1, 2], the output should be solution(n, cabTripTime) = 2.

Trips can be managed like this:

Trip 1: first cab from t = 0 to t = 1;
Trip 2: second cab from t = 0 to t = 2;
Trip 3: first cab from t = 1 to t = 2.
All the trips can be completed in 2 minutes, so the answer is 2.

For n = 10 and cabTripTime = [1, 3, 5, 7], the output should be solution(n, cabTripTime) = 7.

Trips can be managed like this:

Trip 1: first cab from t = 0 to t = 1;
Trip 2: second cab from t = 0 to t = 3;
Trip 3: third cab from t = 0 to t = 5;
Trip 4: fourth cab from t = 0 to t = 7;
Trip 5: first cab from t = 1 to t = 2;
Trip 6: first cab from t = 2 to t = 3;
Trip 7: first cab from t = 3 to t = 4;
Trip 8: second cab from t = 3 to t = 6;
Trip 9: first cab from t = 4 to t = 5;
Trip 10: first cab from t = 5 to t = 6.
All the trips can be completed in 7 minutes, so the answer is 7.

Input/Output

[execution time limit] 3 seconds (java)

[input] integer n

The number of trips that need to be completed.

Guaranteed constraints:
1 < n ≤ 106.

[input] array.integer cabTripTime

Array of time (in minutes) for each cab needed to complete one trip.

Guaranteed constraints:
1 ≤ cabTripTime.length < n,
1 ≤ cabTripTime[i] < 106.

[output] integer

Minimum time it will take Uber to get all n trips completed with the given cabs.
 */

public class findMinTimeToCompleteTrip {

    int solution(int n, int[] cabTripTime) {

        int minTimeCab = getMin(cabTripTime);
        int low = 1;
        int high = minTimeCab * n;
        while (low < high) {
            int mid = (low + high) >> 1;
            int tripsCompletedInMidMinutes = findCompletedTripsCount(cabTripTime, mid);
            if (tripsCompletedInMidMinutes < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    int getMin(int cabTripTime[]) {

        int result = cabTripTime[0];
        for (int i = 1; i < cabTripTime.length; i++) {
            if (cabTripTime[i] < result) {
                result = cabTripTime[i];
            }
        }
        return result;
    }

    int findCompletedTripsCount(int[] cabTripTime, int time) {
        int n = cabTripTime.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = result + time / cabTripTime[i];
        }
        return result;
    }
}
