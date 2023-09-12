package module4.dp5;

public class Interleaving_Strings {
    public int isInterleave(String A, String B, String C) {
        int n = A.length();
        int m = B.length();
        int l = C.length();

        if(l != (m+n)) return 0;

        return interleaving(A, B, C, n-1, m-1, l-1);
    }

    public int interleaving(String A, String B, String C, int i, int j, int k)
    {
        if(i < 0 && j < 0)
        {
            if(k < 0) return 1;
            return 0;
        }

        if(i < 0)
        {

            while(j < 0 && k < 0)
            {
                char c1 = B.charAt(j);
                char c2 = C.charAt(k);

                if(c1 != c2) return 0;
                j --;
                k --;
            }
            return 1;
        }

        if(j < 0)
        {
            char c1 = A.charAt(i);
            char c2 = C.charAt(k);

            while(c1 < 0 && c2 < 0)
            {
                if(c1 != c2) return 0;
            }
            return 1;
        }

        char c1 = A.charAt(i);
        char c2 = B.charAt(j);
        char c3 = C.charAt(k);

        int ans = 0;

        if(c1 == c3 && c2 == c3)
        {
            int t1 = interleaving(A, B, C, i-1, j, k-1);
            int t2 = interleaving(A, B, C, i, j-1, k-1);

            ans = t1 | t2;
        }
        else if(c1 == c3)
        {
            ans = interleaving(A, B, C, i-1, j, k-1);
        }
        else if(c2 == c3)
        {
            ans = interleaving(A, B, C, i, j-1, k-1);
        }

        return ans;
    }
}
