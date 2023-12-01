package FB;

import java.util.ArrayList;
import java.util.List;


/*
https://www.geeksforgeeks.org/backtracking-to-find-all-subsets/
- {A,B,C,D}
output: { {}, {A} {A,B} {A,C} {A,D} {A,B,C,D},{B,C,D},{C,D},{D} } etc all subsets

 */


//public class FBPrep.FBSubSets {
//
//    public static void main(String args[]) {
//
//        char[] input = new char[] {'1','2','3','4'};
//        List<List<Character>> output = getAllSubSets(input);
//        for(List<Character> outputArr : output) {
//            for(Character outputChar : outputArr) {
//                System.out.print(" " + outputChar);
//            }
//            System.out.println();
//
//        }
//    }
//
//    private static List<List<Character>> getAllSubSets( char[] input ) {
//
//        List<List<Character>> outputList = new ArrayList<>();
//        outputList.add(new ArrayList<>());
//        for(char inputChar : input) {
//
//            List<List<Character>> tempList = new ArrayList<>();
//            for(List<Character> outputCharArray : outputList){
//
//                List<Character> tempCharArray = new ArrayList<>();
//                tempCharArray.addAll(outputCharArray);
//                tempCharArray.add(inputChar);
//                tempList.add(tempCharArray);
//            }
//            outputList.addAll(tempList);
//        }
//        return outputList;
//    }
//}



class FBSubSets {
    public static void
    findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index)
    {
        // Base Condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }

    public static void main(String[] args) {

        //FBPrep.Main List for storing all subsets
        List<List<Integer>> subset = new ArrayList<>();

        // Input ArrayList
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);

        findSubsets(subset, input, new ArrayList<>(), 0);

        // Printing Subset
        for(int i = 0; i < subset.size(); i++){
            for(int j = 0; j < subset.get(i).size(); j++){
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}