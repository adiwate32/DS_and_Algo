package module2.string_pattern_matching;

/**
 You are given two strings, A and B, of size N and M, respectively.
 You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.

 Problem Constraints
 1 <= N < M <= 105

 Input Format
 Given two arguments, A and B of type String.

 Output Format
 Return a single integer, i.e., number of permutations of A present in B as a substring.

 Example Input
 Input 1:
 A = "abc"
 B = "abcbacabc"
 Input 2:
 A = "aca"
 B = "acaa"

 Example Output
 Output 1:
 5
 Output 2:
 2

 Example Explanation
 Explanation 1:
 Permutations of A that are present in B as substring are:
 1. abc
 2. cba
 3. bac
 4. cab
 5. abc
 So ans is 5.
 Explanation 2:
 Permutations of A that are present in B as substring are:
 1. aca
 2. caa
 */
public class Permutations_of_A_in_B {
    public int solve(String A, String B) {

        int[] freqA = new int[26];
        int[] freqB = new int[26];

        int n = A.length();
        int m = B.length();

        if(n > m)
        {
            return 0;
        }

        int ans = 0;

        for(int i=0; i<n; i++)
        {
            freqA[A.charAt(i) - 'a']++;
        }

        for(int i=0; i<m; i++)
        {
            freqB[B.charAt(i) - 'a']++;

            if(i>=n)
            {
                freqB[B.charAt(i-n) - 'a']--;
            }

            if(compare(freqA, freqB))
            {
                ans += 1;
            }
        }
        return ans;
    }

    private boolean compare(int[] freqA, int[] freqB)
    {
        for(int i=0; i<26; i++)
        {
            if(freqA[i] != freqB[i])
            {
                return false;
            }
        }
        return true;
    }
}
