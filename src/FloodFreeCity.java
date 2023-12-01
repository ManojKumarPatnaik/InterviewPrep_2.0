import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
https://leetcode.com/problems/avoid-flood-in-the-city/

Input: rains = [1,2,3,4]
Output: [-1,-1,-1,-1]
Explanation: After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day full lakes are [1,2,3]
After the fourth day full lakes are [1,2,3,4]
There's no day to dry any lake and there is no flood in any lake.

imp consideration: dry day should be after the rain day, then only can be used. like 0011 , this is flood condition
 */
class FloodFreeCity {

    public static void main(String args[]) {

        int [] rains = new int [] {1,0,2,0,3,0,2,0,0,0,1,2,3};

        int[] result = avoidFlood(rains);
        for(int output : result)
        System.out.print(output + " ");
    }

    public static int[] avoidFlood(int[] rains) {

        int[] outputArr = new int[rains.length];
        Map<Integer, Integer> isLakeFullMap = new HashMap<>();
        Set<Integer> dryDaySet = new TreeSet<>();

        for(int startIndex = 0; startIndex < rains.length; startIndex++) {

            if(rains[startIndex] > 0) {

                outputArr[startIndex] = -1;
                if(isLakeFullMap.containsKey(rains[startIndex])) {

                    Integer previousRainDayOnLake = isLakeFullMap.get(rains[startIndex]);

                    //check if dry day collection is empty and lake is already full, return flood scenario
                    if(dryDaySet.size() <=0) {
                        return new int[0];
                    }

                    //if dry day collection is not empty then check, if can we use dry day and which one
                    int dryDay = findTheDryDayForLake(dryDaySet, previousRainDayOnLake);

                    //-1 mean, there is no dry day for this lake, then need to return flood scenariio
                    if (dryDay == -1) {
                        return new int[0];
                    } else {

                        //set outputArr[dryDaySet[dryDayIndexUse]] = rains[startIndex]
                        outputArr[dryDay] = rains[startIndex];

                        //remove this rains[startIndex] from dryDaySet
                        dryDaySet.remove(dryDay);

                        //update this rains[startIndex] day in LakeFullMap
                        isLakeFullMap.put(rains[startIndex], startIndex);
                    }

                } else {
                    isLakeFullMap.put(rains[startIndex], startIndex);
                }

            } else {
                dryDaySet.add(startIndex);
            }
        }


        //filling unused dry days with val>0 and <10^9, as mentioned in problem
        for(int i = 0; i<outputArr.length ; i++) {

            if(outputArr[i] == 0 ) {
                outputArr[i] = 1;
            }
        }
        return outputArr;
    }

    private static int findTheDryDayForLake (Set<Integer> dryDaySet, int previousRainDayOnLake) {

        for(int dryDay : dryDaySet) {


            if(dryDay > previousRainDayOnLake)
            {
                return dryDay;
            }
        }

        return -1;
    }

    /************** Start:  without using extra space, using output array only to know info about dry day **********/


    public int[] avoidFloodWithoutSpace(int[] rains) {

        int[] outputArr = new int[rains.length];
        Map<Integer, Integer> isLakeFullMap = new HashMap<>();

        for(int startIndex = 0; startIndex < rains.length; startIndex++) {

            if(rains[startIndex] > 0) {

                outputArr[startIndex] = -1;
                if(isLakeFullMap.containsKey(rains[startIndex])) {

                    Integer previousRainDayOnLake = isLakeFullMap.get(rains[startIndex]);


                    //if dry day collection is not empty then check, if can we use dry day and which one
                    int dryDay = findTheDryDayForLakeWithoutSpace(outputArr, startIndex, previousRainDayOnLake);

                    //-1 mean, there is no dry day for this lake, then need to return flood scenariio
                    if (dryDay == -1) {
                        return new int[0];
                    } else {

                        //set outputArr[dryDaySet[dryDayIndexUse]] = rains[startIndex]
                        outputArr[dryDay] = rains[startIndex];


                        //update this rains[startIndex] inisLakeFullMap with new rain day
                        isLakeFullMap.put(rains[startIndex], startIndex);
                    }

                } else {
                    isLakeFullMap.put(rains[startIndex], startIndex);
                }

            }
        }


        for(int i = 0; i<outputArr.length ; i++) {

            if(outputArr[i] == 0 ) {
                outputArr[i] = 1;
            }
        }
        return outputArr;
    }

    private int findTheDryDayForLakeWithoutSpace (int[] outputArr, int currentDayIndex, int previousRainDayOnLake) {

        for(int dryDay=0; dryDay<currentDayIndex;dryDay++) {


            if(outputArr[dryDay] == 0 && dryDay  > previousRainDayOnLake)
            {
                return dryDay;
            }
        }

        return -1;
    }

    /************** END: without using extra space, using output array only to know info about dry day **********/

}