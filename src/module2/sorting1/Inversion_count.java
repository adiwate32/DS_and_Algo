package module2.sorting1;

/**
 Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).

 Problem Constraints
 1 <= length of the array <= 105
 1 <= A[i] <= 109

 Input Format
 The only argument given is the integer array A.

 Output Format
 Return the number of inversions of A modulo (109 + 7).

 Example Input
 Input 1:
 A = [1, 3, 2]
 Input 2:
 A = [3, 4, 1, 2]

 Example Output
 Output 1:
 1
 Output 2:
 4

 Example Explanation
 Explanation 1:
 The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
 Explanation 2:
 The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
 The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
 The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
 The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
 */
public class Inversion_count {
    long ans = 0;

    int mod = 1000000007;

    public int solve(int[] A) {

        int n = A.length;

        merge_sort(A, 0, n-1);

        return (int) ans % mod;

    }

    public void merge_sort(int[] A, int s, int e)
    {
        if(s == e)
        {
            return;
        }

        int m = (s + e) / 2;
        merge_sort(A, s, m);
        merge_sort(A, m+1, e);
        merge(A, s, e, m);
    }

    public void merge(int[] A, int s, int e, int m) {
        int n = A.length;

        int[] c = new int[e-s+1];

        int p1=s;
        int p2=m+1;
        int k=0;

        while(p1<=m && p2<=e)
        {
            if(A[p1] <= A[p2])
            {
                c[k] = A[p1];
                p1 += 1;
                k += 1;
            }
            else
            {
                c[k] = A[p2];
                p2 += 1;
                k += 1;

                ans += (m % mod - p1 % mod + mod + 1) % mod;
                ans = ans % mod;
            }
        }

        while(p1 <= m)
        {
            c[k] = A[p1];
            p1 += 1;
            k += 1;
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
