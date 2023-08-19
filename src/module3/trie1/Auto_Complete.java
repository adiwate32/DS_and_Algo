package module3.trie1;

import java.util.*;

public class Auto_Complete {
    private static class Pair
    {
        int wei;
        String word;

        Pair(int wei, String word)
        {
            this.wei = wei;
            this.word = word;
        }
    }

    private static class Node
    {
        HashMap<Character, Node> map;
        ArrayList<String> strMap;

        Node()
        {
            map = new HashMap<>();
            strMap = new ArrayList<>();
        }
    }

    private static void insert(Node root, String A)
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
            curr.strMap.add(A);
        }
    }

    private static void find(Node root, String A)
    {
        Node curr = root;
        for(int i=0; i<A.length(); i++)
        {
            char ch = A.charAt(i);
            if(!curr.map.containsKey(ch))
            {
                System.out.println(-1+ " ");
                return;
            }
            else
            {
                curr = curr.map.get(ch);
            }
        }

        ArrayList<String> ans = curr.strMap;

        if(ans.size() > 5)
        {
            List<String> subList = ans.subList(0, 5);
            ans = new ArrayList<>(subList);
        }

        for (String an : ans) {
            System.out.print(an + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int j=0; j<t; j++)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] words = new String[n];
            String[] pre = new String[m];
            int[] weights = new int[n];
            Node root = new Node();

            Pair[] pairs = new Pair[n];

            for(int i=0; i<n; i++)
            {
                words[i] = sc.next();
            }

            for(int i=0; i<n; i++)
            {
                weights[i] = sc.nextInt();
            }

            for(int i=0; i<m; i++)
            {
                pre[i] = sc.next();
            }

            for(int i=0; i<n; i++)
            {
                pairs[i] = new Pair(weights[i], words[i]);
            }

            Arrays.sort(pairs, Comparator.comparingInt((Pair p) -> p.wei).reversed());

            for(int i=0; i<n; i++)
            {
                insert(root, pairs[i].word);
            }

            for(int i=0; i<m; i++)
            {
                find(root, pre[i]);
            }
        }
    }
}
