import java.util.*;

/*

https://leetcode.com/problems/repeated-dna-sequences/
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
 */
class DNADuplicateFinder {

    private static int DNA_SIZE = 10;

    public static void main(String args[]) {

        List<String> duplicateDNASubstring = findDuplicateDNAString("AAAAAAAAAAAAA");
        System.out.println(duplicateDNASubstring);
    }

    private static List<String> findDuplicateDNAString(String dna) {

        List<String> duplicateDNA = new ArrayList<>();
        Map<String, Integer> dnaVsCount = new HashMap<>();
        for (int i = 0; i < dna.length(); i++) {

            if(DNA_SIZE+i > dna.length()) {
                break;
            }
            String dnaSubString = dna.substring(i, DNA_SIZE + i);


            if (dnaVsCount.containsKey(dnaSubString)) {
                int count = dnaVsCount.get(dnaSubString);
                count++;
                dnaVsCount.put(dnaSubString, count);
            } else {
                dnaVsCount.put(dnaSubString, 1);
            }
        }

        for (Map.Entry<String, Integer> set : dnaVsCount.entrySet()) {

            String subString = set.getKey();
            int count = set.getValue();
            if (count > 1) {
                duplicateDNA.add(subString);

            }
        }
        return duplicateDNA;
    }
}
