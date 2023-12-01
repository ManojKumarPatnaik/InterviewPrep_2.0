package FB;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {

    public static int numDecodings(String s) {

        Integer[] mem = new Integer[s.length()];
        return DecodeNumberToCharacter(s, 0, mem);
    }


    private static int DecodeNumberToCharacter(String s, int start, Integer[] cache) {
        if (start == s.length()) return 1;
        if (s.charAt(start) == '0') return 0;
        if (cache[start] != null) return cache[start];
        int result = DecodeNumberToCharacter(s, start + 1, cache);
        if (start < s.length() - 1 &&
                (s.charAt(start) == '1' ||
                (s.charAt(start) == '2' && s.charAt(start + 1) < '7')))
            result += DecodeNumberToCharacter(s, start + 2, cache);

        cache[start] = result;
        return result;
    }

    public static void main(String args[]) {

        String a = "289";
        int output = numDecodings(a);
        System.out.print(output);


    }
}
