package Uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringFollowOrder {


    //remove the unwanted characters and duplicate and then match the string
    private static boolean validatePatternApproach1(String inputString, String pattern) {

        HashSet<Character> patternCharSet = new HashSet<>();
        for (char patternChar : pattern.toCharArray()) {
            patternCharSet.add(patternChar);
        }

        //removing extra characters, which are not there in the pattern
        StringBuilder filteredInputStringRemovingExtraChar = new StringBuilder();
        for (char inputChar : inputString.toCharArray()) {
            if (patternCharSet.contains(inputChar)) {
                filteredInputStringRemovingExtraChar.append(inputChar);
            }
        }

        //remove continuous repeated characters from the previous filtered input string
        StringBuilder filteredStringRemovingDuplicates = new StringBuilder();
        filteredStringRemovingDuplicates.append(filteredInputStringRemovingExtraChar.charAt(0));
        for (int i = 1; i < filteredInputStringRemovingExtraChar.length(); i++) {
            if (filteredInputStringRemovingExtraChar.charAt(i) != filteredInputStringRemovingExtraChar.charAt(i - 1)) {
                filteredStringRemovingDuplicates.append(filteredInputStringRemovingExtraChar.charAt(i));
            }
        }

        return pattern.equals(filteredStringRemovingDuplicates.toString());


    }

    //ranking approach
    private static boolean validatePatternApproach2(String inputString, String pattern) {

        Map<Character, Integer> characterRank = new HashMap<>();
        int rank = 1;
        for (char inputPatternChar : pattern.toCharArray()) {
            characterRank.put(inputPatternChar, rank++);
        }

        int lastRank = 0;
        for (char inputChar : inputString.toCharArray()) {
            if (characterRank.containsKey(inputChar)) {
                int charRank = characterRank.get(inputChar);
                //if we found any character which rank is less and we have seen some character with larger rank,
                // then it means it is not following the pattern
                if (charRank < lastRank) {
                    return false;
                }
                lastRank = charRank;
            }
        }
        return true;
    }

    //lastIndex and FirstIndex approach
    private static boolean validatePatternApproach3(String inputString, String pattern) {

        for (int i=0;i<pattern.length()-1; i++) {

            char firstChar = pattern.charAt(i);
            char secondChar = pattern.charAt(i+1);

            int firstCharLastIndex = inputString.lastIndexOf(firstChar);
            int secondCharFirstIndex = inputString.indexOf(secondChar);

            if(firstCharLastIndex > secondCharFirstIndex) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        String input = "engineers rock";
        String pattern = "er";
        System.out.println(validatePatternApproach1(input, pattern));
        System.out.println(validatePatternApproach2(input, pattern));
        System.out.println(validatePatternApproach3(input, pattern));

    }
}
