package FB;

//https://leetcode.com/problems/prime-palindrome/
public class PrimePalindrome {

    //brute force1
    public int primePalindromeBruteForce(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N))
                return N;
            N++;
        }
    }

    //brute force improvement

    public int primePalindromeBruteForceImprovement(int N) {
        while (true) {

            if (N > 11 && String.valueOf(N).length() % 2 == 0) {
                N = (int) Math.pow(10, String.valueOf(N).length());
            }

            if (N == reverse(N) && isPrime(N))
                return N;
            N++;

        }
    }


    //efficient
    public int primePalindrome(int N) {
        while (true) {

            StringBuilder val = new StringBuilder(String.valueOf(N));
            if (N > 11 && val.length() % 2 == 0) {
                N = (int) Math.pow(10, val.length());
            }

            if (N == reverse(N) && isPrime(N))
                return N;

            int k = (val.length() - 1) / 2;
            int c = val.charAt(k) - '0';
            if (c == 9 || N <= 11) {
                N++;
            } else {
                int newval = c + 1;
                val.setCharAt(k, (char) (newval + '0'));
                int j = 1;
                for (int l = k - 1; l >= 0; l--) {
                    val.setCharAt(k + j, val.charAt(l));
                    j++;

                }
                N = Integer.parseInt(val.toString());
            }
        }
    }

    public boolean isPrime(int N) {
        if (N < 2) return false;
        int Nsqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= Nsqrt; ++i)
            if (N % i == 0) return false;
        return true;
    }

    public int reverse(int N) {
        int reversedVal = 0;
        while (N > 0) {
            reversedVal = 10 * reversedVal + (N % 10);
            N /= 10;
        }
        return reversedVal;
    }

    public static void main(String args[]) {

        PrimePalindrome obj = new PrimePalindrome();
        System.out.println(obj.primePalindrome(102));

    }
}
