package FB;
//https://leetcode.com/problems/powx-n/submissions/

//one use case is x=0.00000001 and n= 2323232323232, if we don't go for divide and conquer approach it will get time out of limit exceed
public class PowerXtoN {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }


        if (n == -1) {
            return 1 / x;
        }

        if (n % 2 == 0) {

            //means its even, so we can use property for ex: x^4 = x^2*x^2
            double value = myPow(x, n / 2);
            return value * value;
        } else {

            //its odd so for ex: x^5 = x^2*x^2*x^1
            double value = myPow(x, n / 2);

            return value * value * myPow(x, n - (n / 2) * 2);
        }


    }
}
