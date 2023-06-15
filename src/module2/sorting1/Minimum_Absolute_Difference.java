package module2.sorting1;

/**
 Given an array of integers A, find and return the minimum value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.

 Problem Constraints
 2 <= length of the array <= 100000
 -109 <= A[i] <= 109

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return the minimum value of | A[i] - A[j] |.

 Example Input
 Input 1:
 A = [1, 2, 3, 4, 5]
 Input 2:
 A = [5, 17, 100, 11]

 Example Output
 Output 1:
 1
 Output 2:
 6

 Example Explanation
 Explanation 1:
 The absolute difference between any two adjacent elements is 1, which is the minimum value.
 Explanation 2:
 The minimum value is 6 (|11 - 5| or |17 - 11|).
 */
public class Minimum_Absolute_Difference {
    public int solve(int[] A) {

        int n = A.length;

        merge_sort(A, 0, n-1);
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<n-1; i++)
        {
            ans = Math.min(ans, Math.abs(A[i] - A[i+1]));
        }
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
