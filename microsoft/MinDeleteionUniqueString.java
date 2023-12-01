package microsoft;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/submissions/
public class MinDeleteionUniqueString {

    public static int minDeletions(String s) {

        int[] charFrequency = new int[26];
        for(char c : s.toCharArray()) {
            charFrequency[c-'a']++;
        }

        Set<Integer> freqAlreadyPresent = new HashSet<>();
        int minDeletion = 0;

        for(int i=0; i<26;i++) {

            while(charFrequency[i] > 0 && freqAlreadyPresent.contains(charFrequency[i])) {

                charFrequency[i]--;
                minDeletion++;
            }

            freqAlreadyPresent.add(charFrequency[i]);
        }


        return minDeletion;
    }


    public static int minDeletionsEfficient(String input) {

        int[] charFrequency = new int[26];
        for (int i = 0; i < input.length(); i++) {
            charFrequency[input.charAt(i) - 'a']++;
        }

        Arrays.sort(charFrequency);

        int deleteCount = 0;
        int nextMaxFreqAllowed = input.length();

        for (int i = 25; i >= 0 && charFrequency[i] > 0; i--) {
            if (charFrequency[i] > nextMaxFreqAllowed) {
                deleteCount += charFrequency[i] - nextMaxFreqAllowed;
                charFrequency[i] = nextMaxFreqAllowed;
            }
            nextMaxFreqAllowed = Math.max(0, charFrequency[i] - 1);
        }

        return deleteCount;
    }


    public static void main(String args[]) {

        String s= "abcabc";
        System.out.println(minDeletionsEfficient(s));
    }
}
