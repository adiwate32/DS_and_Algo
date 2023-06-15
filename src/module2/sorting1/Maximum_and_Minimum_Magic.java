package module2.sorting1;

/**
 Given an array of integers A of size N where N is even.

 Divide the array into two subsets such that

 1.Length of both subset is equal.
 2.Each element of A occurs in exactly one of these subset.
 Magic number = sum of absolute difference of corresponding elements of subset.

 Note: You can reorder the position of elements within the subset to find the value of the magic number.

 For Ex:-
 subset 1 = {1, 5, 1},
 subset 2 = {1, 7, 11}
 Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
 Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.

 Problem Constraints
 1 <= N <= 105
 -109 <= A[i] <= 109
 N is even

 Input Format
 The first argument given is the integer array A.

 Output Format
 Return an array B of size 2, where B[0] = maximum possible value of Magic number % 109 + 7,B[1] = minimum possible value of a Magic number % 109 + 7.

 Example Input
 Input 1:
 A = [3, 11, -1, 5]
 Input 2:
 A = [2, 2]

 Example Output
 Output 1:
 [14, 10]
 Output 2:
 [0, 0]

 Example Explanation
 Explanation 1:
 All possible magical numbers:-
 sub1 = {3, 11}, sub2 = {-1, 5}, Magic Number = abs(3 - -1) + abs(11 - 5) = 10
 sub1 = {3, -1}, sub2 = {11, 5}, Magic Number = abs(3 - 11) + abs(-1 - 5) = 14
 sub1 = {3, 5}, sub2 = {11, -1}, Magic Number = abs(3 - 11) + abs(5 - -1) = 14
 sub1 = {11, -1}, sub2 = {3, 5}, Magic Number = abs(11 - 3) + abs(-1 - 5) = 14
 sub1 = {11, 5}, sub2 = {3, -1}, Magic Number = abs(11 - 3) + abs(5 - -1) = 14
 sub1 = {-1, 5}, sub2 = {3, 11}, Magic Number = abs(-1 - 3) + abs(5 - 11) = 10
 maximum of all magic number = 14 % 10^9 + 7 = 14
 minimum of all magic number = 10 % 10^9 + 7 = 10
 Explanation 2:
 Answer is evident.
 */
public class Maximum_and_Minimum_Magic {
    public int[] solve(int[] A) {

        int n = A.length;
        int mod = 1000000007;

        int[] ans = new int[2];

        merge_sort(A, 0, n-1);
        long mindiff = 0;
        long maxdiff = 0;

        for(int i=0; i<n-1; i+=2)
        {
            mindiff = (mindiff + Math.abs(A[i] - A[i+1]) % mod) % mod;
        }

        for(int i=0; i<n/2; i++)
        {
            maxdiff = (maxdiff + Math.abs(A[i] - A[n-i-1]) % mod) % mod;
        }

        ans[0] = (int)maxdiff;
        ans[1] = (int)mindiff;

        return ans;
    }

    public void merge_sort(int[] A, int s, int e)
    {
        if(s==e)
        {
            return;
        }
        int m = (s + e) / 2;
        merge_sort(A, s, m);
        merge_sort(A, m+1, e);
        merge(A, s, m, e);
    }

    public void merge(int[] A, int s, int m, int e)
    {
        int[] c = new int[e-s+1];

        int p1 = s;
        int p2 = m+1;
        int k = 0;

        while(p1 <=m && p2 <= e)
        {
            if(A[p1] <= A[p2])
            {
                c[k] = A[p1];
                p1 ++;
                k ++;
            }

            else
            {
                c[k] = A[p2];
                p2 += 1;
                k += 1;
            }
        }

        while(p1 <= m)
        {
            c[k] = A[p1];
            p1 ++;
            k ++;
        }

        while(p2 <= e)
        {
            c[k] = A[p2];
            p2 += 1;
            k += 1;
        }

        for(int i=0; i<e-s+1; i++)
        {
            A[i+s] = c[i];
        }
    }
}
