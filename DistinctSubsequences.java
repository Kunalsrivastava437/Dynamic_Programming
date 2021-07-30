import java.util.*;
public class DistinctSubsequences {
    private static int sol(String s, String t, int currS, int currT, int[][] dp){

        int inc=0, exc = 0;

        if(dp[currS][currT]!= -1){
            return dp[currS][currT];
        }

        if(currS >= s.length() && currT >= t.length()){
            return 1;
        }

        if(currS==currT){
            inc = sol(s, t, currS+1, currT+1,dp);
        }
        else{
        exc = sol(s, t, currS+1, currT,dp);
        dp[currS][currT] = inc + exc;
        }
        return dp[currS][currT];


    }
    public static void main(String[] args) {
        String s= "rabbbit";
        String t = "rabbit";
        
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans = sol(s, t, s.length(), t.length(), dp);
        System.out.println(ans);

    }
}
