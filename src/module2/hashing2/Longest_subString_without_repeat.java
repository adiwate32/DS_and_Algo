package module2.hashing2;

import java.util.HashSet;

/**
 Given a string A, find the length of the longest substring without repeating characters.
 Note: Users are expected to solve in O(N) time complexity.

 Problem Constraints
 1 <= size(A) <= 106
 String consists of lowerCase,upperCase characters and digits are also present in the string A.

 Input Format
 Single Argument representing string A.

 Output Format
 Return an integer denoting the maximum possible length of substring without repeating characters.

 Example Input
 Input 1:
 A = "abcabcbb"
 Input 2:
 A = "AaaA"

 Example Output
 Output 1:
 3
 Output 2:
 2

 Example Explanation
 Explanation 1:
 Substring "abc" is the longest substring without repeating characters in string A.
 Explanation 2:
 Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class Longest_subString_without_repeat {
    public int lengthOfLongestSubstring(String A) {

        HashSet<Integer> set = new HashSet<>();

        int l=0;
        int r=0;
        int ans = Integer.MIN_VALUE;
        int n = A.length();

        if(n==1)
        {
            return 1;
        }

        while(r<n)
        {
            int a_r = A.charAt(r);
            int a_l = A.charAt(l);
            if(set.contains(a_r))
            {
                set.remove(a_l);
                l += 1;
            }
            else
            {
                set.add(a_r);
                r += 1;
                ans = Math.max(ans, set.size());
            }
        }
        return ans;
    }
}
