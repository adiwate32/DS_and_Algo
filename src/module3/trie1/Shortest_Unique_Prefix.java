package module3.trie1;

import java.util.HashMap;

/**
 Given a list of N words, find the shortest unique prefix to represent each word in the list.
 NOTE: Assume that no word is the prefix of another. In other words, the representation is always possible

 Problem Constraints
 1 <= Sum of length of all words <= 106

 Input Format
 First and only argument is a string array of size N.

 Output Format
 Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

 Example Input
 Input 1:
 A = ["zebra", "dog", "duck", "dove"]
 Input 2:
 A = ["apple", "ball", "cat"]

 Example Output
 Output 1:
 ["z", "dog", "du", "dov"]
 Output 2:
 ["a", "b", "c"]

 Example Explanation
 Explanation 1:
 Shortest unique prefix of each word is:
 For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
 For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
 For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
 For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".

 Explanation 2:
 "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.
 */
public class Shortest_Unique_Prefix {
    private static class Node
    {
        int cnt;
        HashMap<Character, Node> map;

        Node()
        {
            cnt = 0;
            map = new HashMap<>();
        }
    }

    public String[] prefix(String[] A) {
        Node root = new Node();
        int n = A.length;
        String[] ans = new String[n];

        for (String s : A) {
            insert(root, s);
        }

        for(int i=0; i<n; i++)
        {
            ans[i] = uniquePrefix(root, A[i]);
        }

        return ans;
    }

    public void insert(Node root, String word)
    {
        Node temp = root;

        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);

            if(temp.map.containsKey(ch))
            {
                temp = temp.map.get(ch);
                temp.cnt++;
            }
            else
            {
                Node n1 = new Node();
                temp.map.put(ch, n1);
                temp = temp.map.get(ch);
                temp.cnt ++;
            }
        }
    }

    public String uniquePrefix(Node root, String word)
    {
        StringBuilder sb = new StringBuilder();
        Node temp = root;

        for(int i=0; i<word.length(); i++)
        {
            char ch = word.charAt(i);
            if(temp.map.containsKey(ch))
            {
                if(temp.cnt == 1)
                {
                    break;
                }
                else
                {
                    sb.append(ch);
                    temp = temp.map.get(ch);
                }
            }
        }
        return sb.toString();
    }
}
