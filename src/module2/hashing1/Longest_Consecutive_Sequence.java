package module2.hashing1;

import java.util.HashSet;

/**
 Given an unsorted integer array A of size N.
 Find the length of the longest set of consecutive elements from array A.

 Problem Constraints
 1 <= N <= 106
 -106 <= A[i] <= 106

 Input Format
 First argument is an integer array A of size N.

 Output Format
 Return an integer denoting the length of the longest set of consecutive elements from the array A.

 Example Input
 Input 1:
 A = [100, 4, 200, 1, 3, 2]
 Input 2:
 A = [2, 1]

 Example Output
 Output 1:
 4
 Output 2:
 2

 Example Explanation
 Explanation 1:
 The set of consecutive elements will be [1, 2, 3, 4].
 Explanation 2:
 The set of consecutive elements will be [1, 2].
 */
public class Longest_Consecutive_Sequence {
    public int longestConsecutive(final int[] A) {
        HashSet<Integer> s = new HashSet<Integer>();
        int n = A.length;
        int ans = 0;

        for (int k : A) {
            s.add(k);
        }

        for (int j : A) {
            int x = j;
            if (!s.contains(x - 1)) {
                x += 1;
                int cnt = 1;

                while (s.contains(x)) {
                    x += 1;
                    cnt += 1;
                }
                ans = Math.max(ans, cnt);

            }
        }
        return ans;

    }
}
