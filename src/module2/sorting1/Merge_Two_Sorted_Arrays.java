package module2.sorting1;

/**
 Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

 Problem Constraints
 -1010 <= A[i], B[i] <= 1010

 Input Format
 First Argument is a 1-D array representing  A.
 Second Argument is also a 1-D array representing B.

 Output Format
 Return a 1-D vector which you got after merging A and B.

 Example Input
 Input 1:
 A = [4, 7, 9]
 B = [2, 11, 19]
 Input 2:
 A = [1]
 B = [2]

 Example Output
 Output 1:
 [2, 4, 7, 9, 11, 19]
 Output 2:
 [1, 2]

 Example Explanation
 Explanation 1:
 Merging A and B produces the output as described above.
 Explanation 2:
 Merging A and B produces the output as described above.
 */
public class Merge_Two_Sorted_Arrays {
    public int[] solve(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;

        int[] ans = new int[n+m];

        int p1=0;
        int p2=0;
        int k=0;

        while(p1<n && p2<m)
        {
            if(A[p1] < B[p2])
            {
                ans[k] = A[p1];
                p1 += 1;
            }
            else
            {
                ans[k] = B[p2];
                p2 += 1;
            }
            k += 1;
        }

        while(p1 < n)
        {
            ans[k] = A[p1];
            p1 += 1;
            k += 1;
        }

        while(p2 < m)
        {
            ans[k] = B[p2];
            p2 += 1;
            k += 1;
        }

        return ans;
    }
}
