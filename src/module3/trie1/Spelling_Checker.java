package module3.trie1;

import java.util.HashMap;

/**
 Given an array of words A (dictionary) and another array B (which contain some words).
 You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
 Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
 Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
 NOTE: Try to do this in O(n) time complexity.

 Problem Constraints
 1 <= |A| <= 1000
 1 <= sum of all strings in A <= 50000
 1 <= |B| <= 1000

 Input Format
 First argument is array of strings A.
 First argument is array of strings B.

 Output Format
 Return the binary array of integers according to the given format.

 Example Input
 Input 1:
 A = [ "hat", "cat", "rat" ]
 B = [ "cat", "ball" ]
 Input 2:
 A = [ "tape", "bcci" ]
 B = [ "table", "cci" ]

 Example Output
 Output 1:
 [1, 0]
 Output 2:
 [0, 0]

 Example Explanation
 Explanation 1:
 Only "cat" is present in the dictionary.
 Explanation 2:
 None of the words are present in the dictionary.
 */

public class Spelling_Checker {
    private static class Node
    {
        boolean eow;
        HashMap<Character, Node> map;
        Node()
        {
            eow = false;
            map = new HashMap<>();
        }
    }

    public int[] solve(String[] A, String[] B) {

        int n = B.length;
        int[] ans = new int[n];
        Node root = new Node();

        for (String s : A) {
            insert(root, s);
        }

        for(int i=0; i<n; i++)
        {
            if(search(B[i], root))
            {
                ans[i] = 1;
            }
        }
        return ans;
    }

    public void insert(Node root, String A)
    {
        Node temp = root;

        for(int i=0; i<A.length(); i++)
        {
            char ch = A.charAt(i);

            if(!temp.map.containsKey(ch))
            {
                Node n1 = new Node();
                temp.map.put(ch, n1);
            }
            temp = temp.map.get(ch);
        }

        temp.eow = true;
    }

    public boolean search(String A, Node root)
    {
        Node temp = root;

        for(int i=0; i<A.length(); i++)
        {
            char ch = A.charAt(i);
            if(!temp.map.containsKey(ch))
            {
                return false;
            }
            temp = temp.map.get(ch);
        }

        return temp.eow;
    }
}
