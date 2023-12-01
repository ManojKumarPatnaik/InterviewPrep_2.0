import java.util.*;

/*

https://leetcode.com/problems/add-binary/submissions/
Input: a = "11", b = "1"
Output: "100"

Algo:

Iterate from last on till anyone is not present (a, b, count)
sum all 3
calculate the carry from /
and calculate the value from % and append in from of result.
 */
class AddBinaryNumber {


    public static void main(String args[]) {

        String result = addBinary("111", "11111111");
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {

        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carry = 0;

        String result = "";

        while (aLength >= 0 || bLength >= 0 || carry == 1) {

            int aVal = 0;
            int bVal = 0;
            int sum = 0;

            //finding value of a
            if (aLength >= 0) {
                aVal = Integer.valueOf(a.charAt(aLength)) - Integer.valueOf('0');

            }

            //finding value of b
            if (bLength >= 0) {
                bVal = Integer.valueOf(b.charAt(bLength)) - Integer.valueOf('0');

            }


            //after sum, we can get 1 , 2 or 3
            sum = aVal + bVal + carry;


            carry = sum / 2;
            result = sum % 2 + result;


            aLength--;
            bLength--;
        }

        return result;
    }
}

