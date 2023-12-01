/*
1st iteration of the loop: n = 52

00110100    &               (n)
00110011                    (n-1)
~~~~~~~~
00110000


2nd iteration of the loop: n = 48

00110000    &               (n)
00101111                    (n-1)
~~~~~~~~
00100000


3rd iteration of the loop: n = 32

00100000    &               (n)
00011111                    (n-1)
~~~~~~~~
00000000                    (n = 0)
 */

public class BitNumberOFSetBits {

    // https://www.techiedelight.com/brian-kernighans-algorithm-count-set-bits-integer/

    public static void main(String args[]) {

    int a = (2^2 + 2^3);
    System.out.print(a);
}
}
