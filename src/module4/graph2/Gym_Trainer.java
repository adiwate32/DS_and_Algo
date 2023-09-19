package module4.graph2;

import java.util.ArrayList;
import java.util.HashSet;

/**
 You are the trainer of a gym and there are A people who come to your gym.
 Some of them are friends because they walk together, and some of them are friends because they talk together.
 But people become possessive about each other, so a person cannot walk with one friend and talk with another. Although he can walk with two or more people or talk with two or more people.
 You being the trainer, decided to suggest each one of the 2 possible diets. But friends, being friends will always have the same diet as all the other friends are having.
 Find and return the number of ways you can suggest each of them a diet.
 As the number of ways can be huge, return the answer modulo 109+7.
 NOTE: If there is any person who walks with one person and talks with the another person, then you may return 0.

 Problem Constraints
 1 <= A, N, M <= 105
 1 <= B[i][0], B[i][1], C[i][0], C[i][1] <= A

 Input Format
 The first argument contains an integer A, representing the number of people.
 The second argument contains a 2-D integer array B of size N x 2, where B[i][0] and B[i][1] are friends because they walk together.
 The third argument contains a 2-D integer array C of size M x 2, where C[i][0] and C[i][1] are friends because they talk together.

 Output Format
 Return an integer representing the number of ways to suggest one of the two diets to the people.

 Example Input
 Input 1:
 A = 4
 B = [
 [1, 2]
 ]
 C = [
 [3, 4]
 ]
 Input 2:
 A = 3
 B = [
 [1, 2]
 ]
 C = [
 [1, 3]
 ]

 Example Output
 Output 1:
 4
 Output 2:
 0

 Example Explanation
 Explanation 1:
 There are four ways to suggest the diet:
 Diet-1 to (1, 2) and Diet-2 to (3, 4).
 Diet-1 to (1, 2) and Diet-1 to (3, 4).
 Diet-2 to (1, 2) and Diet-1 to (3, 4).
 Diet-2 to (1, 2) and Diet-2 to (3, 4).
 Explanation 2:
 Person 1 walks with person 2 and talks with person 3. So, we will return 0.
 */
public class Gym_Trainer {
    int mod = 1000000007;
    public int solve(int A, int[][] B, int[][] C) {
        HashSet<Integer> set = new HashSet<>();

        for(int i[]: B)
        {
            set.add(i[0]);
            set.add(i[1]);
        }

        for(int i[]: C)
        {
            if(set.contains(i[0]) || set.contains(i[1])) return 0;
        }

        int[] par = new int[A+1];

        for(int i=0; i<=A; i++)
        {
            par[i] = i;
        }

        for(int i[]: B)
        {
            int par_x = findRoot(par, i[0]);
            int par_y = findRoot(par, i[1]);

            if(par_x != par_y) par[par_x] = par_y;
        }

        for(int i[]: C)
        {
            int par_x = findRoot(par, i[0]);
            int par_y = findRoot(par, i[1]);

            if(par_x != par_y) par[par_x] = par_y;
        }

        long cnt = 0;
        for(int i=1; i<=A; i++)
        {
            if(par[i] == i) cnt++;
        }

        return (int)pow(2, cnt);
    }

    private long pow(long a, long b)
    {
        if(b == 0) return 1;
        long t = pow(a, b/2);
        if(b % 2 == 0) return (t % mod * t % mod) % mod;
        return (a * t % mod * t % mod) % mod;
    }

    private int findRoot(int[] par, int x)
    {
        if(par[x] == x) return x;
        int r = findRoot(par, par[x]);
        par[x] = r;
        return r;
    }
}
