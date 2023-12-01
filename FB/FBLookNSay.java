package FB;/*
https://www.facebook.com/careers/life/sample_interview_questions

print
1
11
21
1211
111221
312211
13112221
1113213211
31131211131221
13211311123113112211
 */

public class FBLookNSay {

    public static void main(String args[]) {

        int n = 10;


        System.out.print("1");
        System.out.println();
        System.out.print("11");
        System.out.println();

        String previousString = "11";
        String currentList = "";

        for (int i = 2; i <= 10; i++) {

            int number =  Integer.valueOf(previousString.charAt(0)) -  Integer.valueOf('0');
            int count = 1;
            for (int si = 1; si < previousString.length(); si++) {
                if ( ( Integer.valueOf(previousString.charAt(si)) -  Integer.valueOf('0')) == number) {
                    count++;
                } else {
                    currentList = currentList + count + number;
                    number =  Integer.valueOf(previousString.charAt(si))-  Integer.valueOf('0');
                    count = 1;
                }

            }

            currentList = currentList + count + number;

            for (char value : currentList.toCharArray()) {
                System.out.print(value);
            }
            System.out.println();
            previousString = currentList;
            currentList = "";
        }
    }
}

/*
Much efficient:

https://leetcode.com/problems/count-and-say/submissions/

class Solution {
    public String countAndSay(int n) {

        if(n == 1) {
            return "1";
        }

        if(n == 2) {
            return "11";
        }

        String previousString = "11";


        for (int i = 2; i < n; i++) {

            StringBuilder currentList = new StringBuilder("");

            char number =  previousString.charAt(0);
            int count = 1;
            for (int si = 1; si < previousString.length(); si++) {
                if ( previousString.charAt(si) == number) {
                    count++;
                } else {
                    currentList = currentList.append(count).append(number);
                    number =  previousString.charAt(si);
                    count = 1;
                }

            }

            currentList = currentList.append(count).append(number);

            previousString = currentList.toString();
        }

        return previousString;
    }

    }

 */
