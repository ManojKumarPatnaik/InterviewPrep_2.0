package google;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indicies 0, 1, 3 and 2 respectively.
 */
class BitWise_BinaryStringContainsAllKbitsCombination {
    public boolean hasAllCodesInefficient(String s, int k) {

        int totalPossibleVaules = (int) Math.pow(2, k);
        int[] kBitPossibleVaules = new int[totalPossibleVaules];

        int pointer1 = 0;
        int pointer2 = k - 1;

        while (pointer2 < s.length()) {

            String subString = s.substring(pointer1, pointer2 + 1);
            int subStringIntValue = Integer.parseInt(subString, 2);
            kBitPossibleVaules[subStringIntValue] = 1;
            pointer1++;
            pointer2++;
        }

        for (int i = 0; i < totalPossibleVaules; i++) {
            if (kBitPossibleVaules[i] == 0) {
                return false;
            }
        }

        return true;

    }

    //efficient approach O(N)

    public boolean hasAllCodes2(String s, int k) {

        int totalNoOfCombinationsNeeded = 1 << k;
        boolean[] combinationFound = new boolean[totalNoOfCombinationsNeeded];
        int allOne = totalNoOfCombinationsNeeded - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            if (i >= k - 1 && !combinationFound[hashVal]) {
                combinationFound[hashVal] = true;
                totalNoOfCombinationsNeeded--;
                if (totalNoOfCombinationsNeeded == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //better  APPROACH: 0(N.M)

    public boolean hasAllCodes(String s, int k) {

        Set<String> kBitPossibleVaules = new HashSet<>();
        int possibleCombinationsNeeded = 1<<k;

        int pointer1 = 0;
        int pointer2 = k-1;

        while(pointer2 < s.length()) {

            String subString = s.substring(pointer1, pointer2+1);
            if(!kBitPossibleVaules.contains(subString)) {
                possibleCombinationsNeeded--;
            }
            if(possibleCombinationsNeeded == 0) {
                return true;
            }

            kBitPossibleVaules.add(subString);
            pointer1++;
            pointer2++;
        }

        return false;

    }
}









