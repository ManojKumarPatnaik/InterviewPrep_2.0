import java.util.Arrays;

/*
https://leetcode.com/problems/boats-to-save-people/

Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

 */
public class BoatsSavePeople {

    public static void main(String args[]) {

        int[] nums = {1, 4, 5, 6, 1, 1, 3};
        int limit = 3;
        int result = numRescueBoats(nums, limit);
        System.out.println(result);
    }

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int start = 0;
        int end = people.length-1;
        int boatCount = 0;

        while(start <= end) {

            boatCount++;
            if(people[end] + people[start] <= limit)
                start++;

            end--;
        }
        return boatCount;

    }
}
