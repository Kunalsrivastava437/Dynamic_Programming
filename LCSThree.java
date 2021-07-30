
import java.util.Arrays;
public class LCSThree {
    public int lcs(String s1, String s2, String s3, int n, int m, int o, int[][][] dp){
        if(n==0 || m==0 || o==0){
            return 0;
        }
        
        if(dp[n][m][o]!= -1){
            return dp[n][m][o];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)
        && s1.charAt(n - 1)==s3.charAt(o - 1)){

            return dp[n][m][o] = 1 + lcs(s1,s2,s3,n-1,m-1,o-1,dp);
        }
        else {
            int c1 = lcs(s1,s2,s3,n,m-1,o,dp);
            int c2 = lcs(s1,s2,s3,n-1,m,o,dp);
            int c3 = lcs(s1,s2,s3,n,m,o-1,dp);
            
            dp[n][m][o] = Math.max(Math.max(c1,c2),c3);
        }
        return dp[n][m][o];
    }
    public static void main(String[] args) {

        LCSThree l = new LCSThree();

        String s1 = "abcde";
        String s2 = "ace";
        String s3 = "axcd";
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        
        for(int[][] row : dp){
            for(int[] column : row){

            Arrays.fill(column,-1);
            }
        }
        int ans = l.lcs(s1, s2, s3, s1.length(), s2.length(), s3.length(),dp);
        System.out.println(ans);
    }
    
}
