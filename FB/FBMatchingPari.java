package FB;/*
https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=559324704673058&c=264896548841891&ppid=454615229006519&practice_plan=0
Matching Pairs
Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
Note: This means you must swap two characters at different indices.
Signature
int matchingPairs(String s, String t)
Input
s and t are strings of length N
N is between 2 and 1,000,000
Output
Return an integer denoting the maximum number of matching pairs
Example 1
s = "abcd"
t = "adcb"
output = 4
Explanation:
Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
Therefore, the number of matching pairs of s and t will be 4.
 */

import java.util.*;
// Add any extra import statements you may need here


class FBMatchingPari {

    // Add any helper functions you may need here


    private static int matchingPairs(String s, String t) {

        //create a hashmap, which has T array character index information
        Map<Character, List<Integer>> charVsIndex = new HashMap<>();
        int index = 0;
        for(char value : t.toCharArray()) {

            if(charVsIndex.containsKey(value)) {
                charVsIndex.get(value).add(index);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(index);
                charVsIndex.put(value,indexList);
            }

            index++;
        }


        //iterate over s & t and find the diff and gain we will get while swapping, so we should only store max gain
        int swapIndex_i = Integer.MAX_VALUE;
        int swapIndex_j = Integer.MAX_VALUE;
        int gain = Integer.MIN_VALUE;
        int matchedCount = 0;

        for(int s_index = 0; s_index < s.length(); s_index++) {

            char sChar = s.charAt(s_index);
            char tChar = t.charAt(s_index);

            if(sChar == tChar) {
                matchedCount++;
                continue;
            }

            //now we have a mismatch
            //1st check does sChar Present in t or not
            if(!charVsIndex.containsKey(sChar)) {


                if(gain == Integer.MIN_VALUE) {

                    gain = 0;
                    if(swapIndex_i == Integer.MAX_VALUE) {
                        swapIndex_i = s_index;
                    }
                    if(swapIndex_j == Integer.MAX_VALUE) {
                        swapIndex_j = s_index;
                    }
                }

            } else {

                List<Integer> indexList = charVsIndex.get(sChar);

                for(int indexVal: indexList) {

                    if(s.charAt(indexVal) == t.charAt(s_index))
                    {
                        gain = 2;
                        swapIndex_i = s_index;
                        swapIndex_j = indexVal;
                        break;
                    } else {

                        if(gain == 0 || gain == Integer.MIN_VALUE) {
                            gain = 1;
                            swapIndex_i = s_index;
                            swapIndex_j = indexVal;
                        }
                    }
                }
            }

        }


        //both swap i and j are empty, means strings are exactly same
        if(gain == Integer.MIN_VALUE && swapIndex_i == Integer.MAX_VALUE && swapIndex_j == Integer.MAX_VALUE) {
            return s.length()-2;
        }else if(gain == 2 && swapIndex_i != Integer.MAX_VALUE && swapIndex_j != Integer.MAX_VALUE) {
            return matchedCount+2;
        }else if(gain == 0){
            return matchedCount -1;
        } else  {
            return matchedCount+1;
        }


    }

    public static void main(String[] args) {

        /*
        s="ax" t="ay" (return 0)
    s="axb" t="ayb" (return 1)
    s="axa" t="aya" (return 2) // my code not working
    s="abx" t="abb" (return 2)  // my code not working
    s="abb" t="axb" (return 2)  // not working
         */
        String s_1 = "abb";
        String t_1 = "axb";
        int output = matchingPairs(s_1,t_1);
        System.out.println(output);
    }
}


//someone else working solution
/*

int matchingPairs(String s, String t) {
        Set<String> unMatched = new HashSet<String>();
        Set<Character> matched = new HashSet<Character>();
        int count = 0;
        boolean isDup = false;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == t.charAt(i)) {
                count++;
                if(matched.contains(s.charAt(i))) {
                    isDup = true;
                }
                matched.add(s.charAt(i));
            } else {
                unMatched.add(s.charAt(i) + "" + t.charAt(i));
            }
        }

        if(count == s.length()) {
            return isDup ? count :  count - 2;
        }

        if(count == s.length() - 1) {
            String onlyUnmatched = (String)unMatched.toArray()[0];
            if(isDup || matched.contains(onlyUnmatched.charAt(0)) || matched.contains(onlyUnmatched.charAt(1)))
                return count;
            return count - 1;
        }

        for(String um:unMatched) {
            if(unMatched.contains(um.charAt(1)+""+um.charAt(0))) {
                return count + 2;
            }
        }

        Set<Character> unMatchedS = new HashSet<>();
        Set<Character> unMatchedT = new HashSet<>();

        for(String um : unMatched) {
            if(unMatchedS.contains(um.charAt(1)) || unMatchedT.contains(um.charAt(0))) {
                return count + 1;
            }
           unMatchedS.add(um.charAt(0));
           unMatchedT.add(um.charAt(1));
        }
        return count;
    }
 */