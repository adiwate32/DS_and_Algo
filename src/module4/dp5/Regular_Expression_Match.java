package module4.dp5;

import java.util.Arrays;

public class Regular_Expression_Match {
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        StringBuilder sb = new StringBuilder();
        //removing extra char * if they are side by side in B to avoid java heap space issue for hard test case
        for(int i=0;i<m-1;i++){
            if(B.charAt(i)== '*' && B.charAt(i+1) == '*') continue;
            sb.append(B.charAt(i));
        }
        sb.append(B.charAt(m-1));
        String s = sb.toString();
        m = s.length();
        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);

        return matching(A,s,n-1,m-1,dp);
    }
    public int matching(String A,String B,int i,int j,int[][] dp){
        if(i<0 && j<0) return 1;
        //if still chars left in B
        if(i<0){
            while(j>=0){
                if(B.charAt(j)=='*') j--;
                else return 0;
            }
            return 1;
        }
        //if still chars left in A
        if(j<0) return 0;

        if(dp[i][j]==-1){
            //if chars are equal check the previous one.
            if(A.charAt(i) == B.charAt(j)){
                dp[i][j] = matching(A,B,i-1,j-1,dp);
            }
            // Three possibilities if B char is *
            else if(B.charAt(j)=='*'){
                dp[i][j] = (matching(A,B,i-1,j-1,dp) | matching(A,B,i-1,j,dp)) | matching(A,B,i,j-1,dp);
            }
            //Only one possibility if B char is ?
            else if(B.charAt(j)=='?'){
                dp[i][j] = matching(A,B,i-1,j-1,dp);
            }
            //if char are not equal return 0
            else{
                dp[i][j] = 0;
            }
        }
        return dp[i][j];
    }
}
