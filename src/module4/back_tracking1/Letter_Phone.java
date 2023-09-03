package module4.back_tracking1;

import java.util.ArrayList;

/**
 Given a digit string A, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.

 The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
 NOTE: Make sure the returned strings are lexicographically sorted.

 Problem Constraints
 1 <= |A| <= 10

 Input Format
 The only argument is a digit string A.

 Output Format
 Return a string array denoting the possible letter combinations.

 Example Input
 Input 1:
 A = "23"
 Input 2:
 A = "012"

 Example Output
 Output 1:
 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 Output 2:
 ["01a", "01b", "01c"]

 Example Explanation
 Explanation 1:
 There are 9 possible letter combinations.
 Explanation 2:
 Only 3 possible letter combinations.
 */
public class Letter_Phone {
    ArrayList<String> ans = new ArrayList<>();
    public ArrayList<String> letterCombinations(String A) {

        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder res = new StringBuilder();

        combinations(A, 0, res, map);
        return ans;

    }

    private void combinations(String A, int i, StringBuilder res, String[] map)
    {
        if(i == A.length())
        {
            ans.add(String.valueOf(res));
            return;
        }

        char ch = A.charAt(i);
        String s = map[ch - '0'];
        for(int k=0; k<s.length(); k++)
        {
            res.append(s.charAt(k));
            combinations(A, i+1, res, map);
            res.delete(res.length()-1, res.length());
        }
    }
}
