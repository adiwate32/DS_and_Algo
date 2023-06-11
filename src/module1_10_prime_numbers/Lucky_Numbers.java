package module1_10_prime_numbers;

import java.util.HashMap;

/**
 A lucky number is a number that has exactly 2 distinct prime divisors.

 You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

 Problem Constraints
 1 <= A <= 50000

 Input Format
 The first and only argument is an integer A.

 Output Format
 Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.

 Example Input
 Input 1:
 A = 8
 Input 2:
 A = 12

 Example Output
 Output 1:
 1
 Output 2:
 3

 Example Explanation
 Explanation 1:
 Between [1, 8] there is only 1 lucky number i.e 6.
 6 has 2 distinct prime factors i.e 2 and 3.
 Explanation 2:
 Between [1, 12] there are 3 lucky number: 6, 10 and 12.
 */
public class Lucky_Numbers {
    public int solve(int A) {

        int [] spf = smallest_prime_factor(A);
        int ans = 0;


        for(int i=2; i<=A; i++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            int x = i;

            while(x > 1)
            {
                if(map.containsKey(spf[x]))
                {
                    map.put(spf[x], (map.get(spf[x]) + 1));
                }
                else
                {
                    map.put(spf[x], 1);
                }

                x = x / spf[x];
            }


            if(map.size() == 2)
            {
                ans += 1;
            }
        }
        return ans;
    }

    public int[] smallest_prime_factor(int A) {
        int[] spf = new int[A+1];

        for(int i=2; i<=A; i++)
        {
            spf[i] = i;
        }


        for(int i=2; i*i<=A; i++)
        {
            if(spf[i] == i)
            {
                for(int j=i*i; j<=A; j+=i)
                {
                    if(spf[j] == j)
                    {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
}
