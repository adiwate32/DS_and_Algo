package module3.trie1;

import java.util.ArrayList;
import java.util.HashMap;

/**
 We want to make a custom contacts finder applications as part of our college project. The application must perform two types of operations:
 Type 1: Add name B[i] ,denoted by 0 in vector A where B[i] is a string in vector B denoting a contact name. This must store B[i] as a new contact in the application.
 Type 2: Find partial for B[i] ,denoted by 1 in vector A where B[i] is a string in vector B denoting a partial name to search the application for. It must count the number of contacts starting with B[i].
 You have been given sequential add and find operations. You need to perform each operation in order.
 And return as an array of integers, answers for each query of type 2(denoted by 1 in A) .

 Problem Constraints
 1 <= |A| <= 10000
 1 <= |length of strings in B| <= 10

 Input Format
 First argument is the vector A, which denotes the type of query.
 Second argument is the vector B, which denotes the string for corresponding query.

 Output Format
 Return an array of integers, denoting answers for each query of type 1.

 Example Input
 Input 1:
 A = [0, 0, 1, 1]
 B = ["hack", "hacker", "hac", "hak"]
 Input 2:
 A = [0, 1]
 B = ["abcde", "abc"]

 Example Output
 Output 1:
 [2, 0]
 Output 2:
 [1]

 Example Explanation
 Explanation 1:
 We perform the following sequence of operations:
 Add a contact named "hack".
 Add a contact named "hacker".
 Find the number of contact names beginning with "hac". There are currently two contact names in the application and both of them start with "hac", so we have 2.
 Find the number of contact names beginning with "hak". There are currently two contact names in the application but neither of them start with "hak", so we get0.
 Explanation 2:
 Add "abcde"
 Find words with prefix "abc". We have answer as 1.
 */
public class Contact_Finder {
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

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B) {

        ArrayList<Integer> ans = new ArrayList<>();
        Node root = new Node();
        for(int i=0; i<A.size(); i++)
        {
            if(A.get(i) == 0)
            {
                insert(root, B.get(i));
            }
            else
            {
                ans.add(find(root, B.get(i)));
            }
        }
        return ans;
    }

    public void insert(Node root, String A)
    {
        Node curr = root;
        for(int i=0; i<A.length(); i++)
        {
            char ch = A.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                Node nn = new Node();
                curr.map.put(ch, nn);
            }
            curr = curr.map.get(ch);
            curr.cnt ++;
        }
    }

    public int find(Node root, String A)
    {
        Node curr = root;
        for(int i=0; i<A.length(); i++)
        {
            char ch = A.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                return 0;
            }
            curr=curr.map.get(ch);
        }

        return curr.cnt;
    }
}
