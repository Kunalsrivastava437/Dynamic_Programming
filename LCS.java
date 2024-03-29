
import java.util.Arrays;
public class LCS {

    public int lcs(String s1, String s2, int n, int m, int[][] dp){
        if(n==0 || m==0){
            return 0;
        }
        
        if(dp[n][m]!= -1){
            return dp[n][m];
        }
        
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = 1 + lcs(s1,s2,n-1,m-1,dp);
        }else{
            int c1 = lcs(s1,s2,n,m-1,dp);
            int c2 = lcs(s1,s2,n-1,m,dp);
            
            return dp[n][m] = Math.max(c1,c2);
        }
    }
    public static void main(String[] args) {

        LCS l = new LCS();

        String s1 = "abcde";
        String s2 = "ace";
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        for(int[] row : dp){

            Arrays.fill(row,-1);
        }
        int ans = l.lcs(s1, s2, s1.length(), s2.length(), dp);
        System.out.println(ans);
    }
}
