package FB;

public class PalindromeOrNotRemove1char {

    private static boolean checkPlainPalindrome(String input, int start, int end) {
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isPalindrome(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) == input.charAt(end)) {
                start++;
                end--;
            } else {
                if (checkPlainPalindrome(input, start+1, end)) {
                    return true;
                }
                if (checkPlainPalindrome(input, start, end-1)) {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        String input = "KBAYAK";
        System.out.println(isPalindrome(input));
    }
}
