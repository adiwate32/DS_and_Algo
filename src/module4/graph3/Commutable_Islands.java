package module4.graph3;

import java.util.Arrays;
import java.util.Comparator;

public class Commutable_Islands {
    public int solve(int A, int[][] B) {
        int [] par = new int [A+1];

        for(int i=0; i<=A; i++)
        {
            par[i] = i;
        }

        Arrays.sort(B, new Comparator<int []>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[2] - b[2];
            }
        });

        int ans = 0;

        for(int i=0; i<B.length; i++)
        {
            int x = B[i][0];
            int y = B[i][1];
            int wt = B[i][2];

            int par_x = findroot(par, x);
            int par_y = findroot(par, y);
            if(par_x != par_y)
            {
                par[par_x] = par_y;
                ans += wt;
            }
        }
        return ans;
    }

    public int findroot(int[] par, int x)
    {
        if(par[x] == x) return x;
        int r = findroot(par, par[x]);
        par[x] = r;
        return r;
    }
}
