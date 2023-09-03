package module4.dp1;

public class Ways_to_Decode {
    public int numDecodings(String A) {
        int n = A.length();

        long[] dp = new long[n+1];
        dp[0] = 1;
        int mod = 1000000007;


        for(int i=1; i<=n; i++)
        {
            int val1 = Integer.parseInt(A.substring(i - 1, i));

            if(val1 >= 1 && val1 <= 9)
            {
                dp[i] = dp[i-1];
            }

            if(i > 1)
            {
                int val2 = Integer.parseInt(A.substring(i - 2, i));
                if(val2 >= 10 && val2 <= 26)
                {
                    dp[i] = (dp[i] + dp[i-2]) % mod;
                }
            }
        }

        return (int)dp[n];
    }
}
