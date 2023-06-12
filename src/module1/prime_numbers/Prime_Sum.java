package module1.prime_numbers;

import java.util.Arrays;

/**
 Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

 If there is more than one solution possible, return the lexicographically smaller solution.

 If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
 [a, b] < [c, d], If a < c OR a==c AND b < d.
 NOTE: A solution will always exist. Read Goldbach's conjecture.

 Problem Constraints
 4 <= A <= 2*107

 Input Format
 First and only argument of input is an even number A.

 Output Format
 Return a integer array of size 2 containing primes whose sum will be equal to given number.

 Example Input
 4

 Example Output
 [2, 2]
 Example Explanation
 There is only 1 solution for A = 4.
 */
public class Prime_Sum {
    public int[] primesum(int A) {

        boolean[] prime = isPrime(A);
        int [] ans = new int[2];

        for(int i=2; i<=A; i++)
        {
            if(prime[i] && prime[A-i])
            {
                ans[0] = i;
                ans[1] = A-i;
                break;
            }
        }
        return ans;
    }

    public boolean[] isPrime(int A)
    {
        boolean[] pf = new boolean[A+1];
        Arrays.fill(pf, true);

        for(int i=2; i*i<=A; i++)
        {
            if(pf[i] == true)
            {
                for(int j=i*i; j<=A; j+=i)
                {
                    pf[j] = false;
                }
            }
        }
        return pf;
    }
}
