package module1.prime_numbers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 Given an integer A. Find the list of all prime numbers in the range [1, A].

 Problem Constraints
 1 <= A <= 106

 Input Format
 Only argument A is an integer.

 Output Format
 Return a sorted array of prime number in the range [1, A].

 Example Input
 Input 1:
 A = 7
 Input 2:
 A = 12

 Example Output
 Output 1:
 [2, 3, 5, 7]
 Output 2:
 [2, 3, 5, 7, 11]

 Example Explanation
 For Input 1:
 The prime numbers from 1 to 7 are 2, 3, 5 and 7.
 For Input 2:
 The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.
 */

public class Find_All_Primes {
    public ArrayList<Integer> solve(int A) {
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
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=2; i<=A; i++)
        {
            if(pf[i] == true)
            {
                ans.add(i);
            }
        }

        return ans;
    }
}
