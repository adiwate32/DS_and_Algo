package module1_10_prime_numbers;

import java.util.HashMap;

/**
 Given an array of integers A, find and return the count of divisors of each element of the array.
 NOTE: The order of the resultant array should be the same as the input array.

 Problem Constraints
 1 <= length of the array <= 100000
 1 <= A[i] <= 106

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return the count of divisors of each element of the array in the form of an array.

 Example Input
 Input 1:
 A = [2, 3, 4, 5]
 Input 2:
 A = [8, 9, 10]

 Example Output
 Output 1:
 [2, 2, 3, 2]
 Output 1:
 [4, 3, 4]


 Example Explanation
 Explanation 1:
 The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
 So the count will be [2, 2, 3, 2].
 Explanation 2:
 The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
 So the count will be [4, 3, 4].
 */

public class Count_of_divisors {
    public int[] solve(int[] A) {

        int n = A.length;
        int[] ans = new int[n];
        int max = max_ele(A);
        int [] spf = smallest_prime_factor(max);


        for(int i=0; i<n; i++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();

            int cnt = 1;
            int x = A[i];

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

            for(int key: map.keySet())
            {
                int val = map.get(key);
                cnt = cnt * (val + 1);
            }

            ans[i] = cnt;
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

    public int max_ele(int[] A)
    {
        int max = A[0];

        for(int i=1; i<A.length; i++)
        {
            if(A[i] > max)
            {
                max = A[i];
            }
        }
        return max;

    }
}
