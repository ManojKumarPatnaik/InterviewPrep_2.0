package Uber;

import java.util.Arrays;
import java.util.LinkedList;

/*
There is a long road with markers on it after each unit of distance. There are some ubers standing on the road. You are given the starting and ending coordinate of each uber (both inclusive).
Note: At any given marker there may be multiple ubers or there may be none at all.

Your task is to find the number of markers on which at least one uber is present. An uber with coordinates (l, r) is considered to be present on a marker m if and only if l ≤ m ≤ r.

Example

For coordinates=[[4, 7], [-1, 5], [3, 6]], the output should be solution(coordinates) = 9.
 */

public class findAtlest1CarRange {

    int solution(int[][] coordinates) {

        Arrays.sort(coordinates, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> coordinatesWithUber = new LinkedList<>();
        for (int[] uberCoordinate : coordinates) {

            if (coordinatesWithUber.isEmpty() || coordinatesWithUber.getLast()[1] < uberCoordinate[0]) {
                coordinatesWithUber.add(uberCoordinate);
            } else {
                coordinatesWithUber.getLast()[1] = Math.max(coordinatesWithUber.getLast()[1], uberCoordinate[1]);
            }
        }

        int output = 0;
        for (int[] values : coordinatesWithUber) {
            output = output + (values[1] - values[0] + 1);
        }

        return output;

    }
}
