package module4.back_tracking2;

import java.util.ArrayList;

/**
 Given a string A, partition A such that every string of the partition is a palindrome.
 Return all possible palindrome partitioning of A.
 Ordering the results in the answer : Entry i will come before Entry j if :
 len(Entryi[0]) < len(Entryj[0]) OR
 (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
 (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))

 Problem Constraints
 1 <= len(A) <= 15

 Input Format
 First argument is a string A of lowercase characters.

 Output Format
 Return a list of all possible palindrome partitioning of s.

 Example Input
 Input 1:
 A = "aab"
 Input 2:
 A = "a"

 Example Output
 Output 1:
 [
 ["a","a","b"]
 ["aa","b"],
 ]
 Output 2:
 [
 ["a"]
 ]

 Example Explanation
 Explanation 1:
 In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
 Explanation 2:
 In the given example, only partition possible is "a" .
 */
public class Palindrome_Partitioning {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    public ArrayList<ArrayList<String>> partition(String a) {
        partition(a, new ArrayList<>());
        return ans;
    }

    public void partition(String A, ArrayList<String> res)
    {
        if(A.length() == 0)
        {
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=0; i<A.length(); i++)
        {
            String pre = A.substring(0, i+1);
            if(isValidPalindrome(pre))
            {
                res.add(pre);
                String suff = A.substring(i+1);
                partition(suff, res);
                res.remove(res.size()-1);
            }
        }
    }

    private boolean isValidPalindrome(String A)
    {
        String rev = "";

        for(int i=0; i<A.length(); i++)
        {
            rev = A.charAt(i) + rev;
        }

        return rev.equals(A);
    }
}
