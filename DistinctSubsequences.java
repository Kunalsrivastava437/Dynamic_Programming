import java.util.*;
public class DistinctSubsequences {
    private static int sol(String s, String t, int currS, int currT, int[][] dp){

        int inc, exc = 0;

        if(dp[currS][currT]!= -1){
            return dp[currS][currT];
        }

        if(currS >= s.length && currT >= t.length){
            return 1;
        }

        if(currS==currT){
            int inc = sol(s, t, currS+1, currT+1,dp);
        }
        
        int exc = sol(s, t, currS+1, currT,dp);
        return dp[currS][currT] = inc + exc;


    }
    public static void main(String[] args) {
        String s= "rabbbit";
        String t = "rabbit";
        
        int[][] dp = new int[7][6];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans = sol(s, t, 6, 5,dp);
        System.out.println(ans);

    }
}
