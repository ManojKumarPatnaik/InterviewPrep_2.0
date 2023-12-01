package google;

//https://leetcode.com/problems/delete-operation-for-two-strings/
public class DeleteOperationForTwoStrings {


    public int minDistanceInefficient(String s1, String s2) {

        return s1.length() + s2.length() - 2*lcsInefficient(s1,s2,0,0);
    }

    private int lcsInefficient(String s1, String s2, int indexS1, int indexS2) {

        if (indexS1 == s1.length() || indexS2 == s2.length()) {
            return 0;
        }

        if (s1.charAt(indexS1) == s2.charAt(indexS2)) {
            return 1 + lcsInefficient(s1, s2, indexS1 + 1, indexS2 + 1);
        } else {

            return Math.max(lcsInefficient(s1, s2, indexS1 + 1, indexS2), lcsInefficient(s1, s2, indexS1, indexS2 + 1));
        }
    }

    public int minDistanceRecursionWithMemo(String s1, String s2) {

        int[][] cache = new int[s1.length()][s2.length()];
        return s1.length() + s2.length() - 2*lcsRecursionWithMemo(s1,s2,0,0,cache);
    }

    private int lcsRecursionWithMemo(String s1, String s2, int indexS1, int indexS2, int[][] cache) {

        if (indexS1 == s1.length() || indexS2 == s2.length()) {
            return 0;
        }

        if(cache[indexS1][indexS2] != 0) {
            return cache[indexS1][indexS2];
        }

        if (s1.charAt(indexS1) == s2.charAt(indexS2)) {
            cache[indexS1][indexS2] = 1 + lcsRecursionWithMemo(s1, s2, indexS1 + 1, indexS2 + 1, cache);
        }
        else {
            cache[indexS1][indexS2] =  Math.max(lcsRecursionWithMemo(s1, s2, indexS1 + 1, indexS2, cache),
                    lcsRecursionWithMemo(s1, s2, indexS1, indexS2 + 1, cache));
        }

        return cache[indexS1][indexS2];

    }

    public int minDistance(String s1, String s2) {

        return s1.length() + s2.length() - 2 * lcs(s1, s2);
    }

    private int lcs(String s1, String s2) {

        int[][] tableForLCS = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    tableForLCS[i][j] = 0;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tableForLCS[i][j] = tableForLCS[i - 1][j - 1] + 1;
                }
                else {
                    tableForLCS[i][j] = Math.max(tableForLCS[i - 1][j], tableForLCS[i][j - 1]);
                }
            }
        }
        return tableForLCS[s1.length()][s2.length()];

    }

    public static void main(String args[]) {

        DeleteOperationForTwoStrings obj = new DeleteOperationForTwoStrings();
        String s1 ="lteecode";
        String s2 ="etco";

        System.out.println(obj.minDistance(s1,s2));


    }
}
