import java.util.*;
class LPS {
    public int longestPalindromeSubseq(String s) {
 
        int[][] dp = new int[s.length()+1][s.length()+1];
        
        for(int[] row : dp){

            Arrays.fill(row,-1);
        }
        return lcs(s,0,s.length(),dp);
    }
    
    
    public int lcs(String s1, int n, int m, int[][] dp){
        if(n>=m){
            return 0;
        }
        if(m-n==1){
            return 1;
        }
        if(dp[n][m]!= -1){
            return dp[n][m];
        }
        
        if(s1.charAt(n)==s1.charAt(m-1)){
            return dp[n][m] = 2 + lcs(s1,n+1,m-1,dp);
        }else{
        int c1 = lcs(s1,n,m-1,dp);
        int c2 = lcs(s1,n+1,m,dp);
            
        dp[n][m] = Math.max(c1,c2);
}return dp[n][m];
}
}
