package module2.hashing2;

import java.util.HashMap;

/**
 Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
 Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
 Note:
 If there is no such window in A that covers all characters in B, return the empty string.
 If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )

 Problem Constraints
 1 <= size(A), size(B) <= 106

 Input Format
 The first argument is a string A.
 The second argument is a string B.

 Output Format
 Return a string denoting the minimum window.

 Example Input
 Input 1:
 A = "ADOBECODEBANC"
 B = "ABC"
 Input 2:
 A = "Aa91b"
 B = "ab"

 Example Output
 Output 1:
 "BANC"
 Output 2:
 "a91b"

 Example Explanation
 Explanation 1:
 "BANC" is a substring of A which contains all characters of B.
 Explanation 2:
 "a91b" is the substring of A which contains all characters of B.
 */

public class Window_String {
    public String minWindow(String A, String B) {
        int n = A.length();
        int m = B.length();

        if(m > n)
        {
            return "";
        }

        HashMap<Integer, Integer> A_map = new HashMap<>();
        HashMap<Integer, Integer> B_map = new HashMap<>();

        for(int i=0; i<m; i++)
        {
            int a = (int)A.charAt(i);
            int b = (int)B.charAt(i);

            A_map.put(a, A_map.getOrDefault(a, 0) + 1);
            B_map.put(b, B_map.getOrDefault(b, 0) + 1);
        }

        int l = 0;
        int r = m-1;
        int s = 0;
        int flag = 0;
        int minLen = Integer.MAX_VALUE;

        while(r < n)
        {
            if(check_len(A_map, B_map))
            {
                flag = 1;
                if(minLen > r - l + 1)
                {
                    minLen = r - l + 1;
                    s = l;
                }
                int a = (int)A.charAt(l);
                A_map.put(a, A_map.getOrDefault(a, 0) - 1);
                l += 1;
            }
            else
            {
                r += 1;
                if(r == n)
                {
                    break;
                }
                else{
                    int a = (int)A.charAt(r);
                    A_map.put(a, A_map.getOrDefault(a, 0) + 1);
                }

            }
        }
        return flag == 1 ? A.substring(s, s+minLen): "";
    }

    private boolean check_len(HashMap<Integer, Integer> A, HashMap<Integer, Integer> B)
    {
        for(int i=0; i<256; i++)
        {
            int a = A.getOrDefault(i, 0);
            int b = B.getOrDefault(i, 0);

            if(b!=0)
            {
                if(a < b)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
