package module4.dp1;

public class Max_Product_Subarray {
    public int maxProduct(final int[] A) {
        int n = A.length;

        int[] max_dp = new int[n];
        int[] min_dp = new int[n];

        max_dp[0] = A[0];
        min_dp[0] = A[0];

        int res = A[0];

        for(int i=1; i<A.length; i++)
        {
            if(A[i] < 0)
            {
                max_dp[i] = Math.max(min_dp[i-1] * A[i], A[i]);
                min_dp[i] = Math.min(max_dp[i-1] * A[i], A[i]);
            }
            else
            {
                min_dp[i] = Math.min(min_dp[i-1] * A[i], A[i]);
                max_dp[i] = Math.max(max_dp[i-1] * A[i], A[i]);
            }

            res = Math.max(res, max_dp[i]);
        }

        return res;
    }
}
