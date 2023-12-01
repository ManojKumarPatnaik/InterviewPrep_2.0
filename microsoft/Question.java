package microsoft;

/*

1. There are N block from 0 to N-1.
A couple of frogs were sitting together on one block, They had a quarrel and need to jump away from one another. The frogs can only jump to another block if the height of the other block is greater than equal to the current one. You need to find the longest possible distance that they can possible create between each other,
if they also choose to sit on an optimal starting block initially.

my solution1:

for each index i calculated, how far frog can go to left and how far frog can go right and return the distance.
Then out of all index max distance, i choose the one max.


2. We are given two arrays A and B, consisting of N integers each. We want to merge them into array C such that, for each index K (from 0 to N - 1), C[K] can be either A[K] or B[K]. For example, arrays A = [1, 2, 4, 3] and B = [1, 3, 2, 3] can be merged in any one of the the following ways:

[1,2,4,3] [1,3,4,3] [1,2,2,3] [1,3,2,3]
Our goal is to obtain C such that the smallest positive integer not present in C is as small as possible. In the arrangements in our example, this value would be 5, 2, 4 and 4 respectively. So, our solution is 2nd arrangement, which results in 2.


 My solution2:

Let's say, the input is:

A = [3, 2, 1, 6, 5, 3] and B = [4, 2, 1, 3, 3, 3]
According to your approach, C would be created as: [4, 2, 1, 6, 5, 3], and hence, the answer will be 7

But a possible C could be: [3, 2, 1, 6, 5, 3], which results in the answer being 4. Notice that for C[0], we took the lower of A[0] and B[0].

I think this case should ring some bells. Here is my approach:

- Since we have 0 < A[i], B[i] <= 10^5, create a helper array, say H of size 10^5 + 1 and initialize it to zeroes.
- Now, iterate over A and B, looking for those values where A[i] == B[i], and for those values, set H[A[i]] = 1
- Once again iterate over A and B. If H[A[i]] == 1 or H[B[i]] == 1, continue. Else, set H[max(A[i], B[i])] = 1.
- Now, iterate over H from index 1 onwards. The index on which you find your 1st 0 is your answer.




- Given an integer N, return the smallest non-negative number whose individual digits sum upto N.
class Solution{
    public int getSmellestNumber(int num){
        int noOfNines= num/9;
        int res= num%9;
        while(noOfNines > 0){
            res= res*10 + 9;
            noOfNines--;
        }

        return res;
    }
}
 */

public class Question {
}
