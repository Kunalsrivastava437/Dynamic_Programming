import java.util.Arrays;
public class EditDistance {
    
        public int minDistance(String word1, String word2) {
            int[][] dp = new int[word1.length()+1][word2.length()+1];
            for(int[] row : dp){
                Arrays.fill(row,-1);
            }
            
            return sol(word1, word2, word1.length(), word2.length(), dp);
        }
        
        public int sol(String s1, String s2, int n, int m, int[][] dp){
            
            if(n==0 && m==0){
                return 0;
            }
            
            if(n==0){
                return m;
            }
            if(m==0){
                return n;
            }
            if(dp[n][m]!=-1){
                return dp[n][m];
            }
            
            if(s1.charAt(n-1)==s2.charAt(m-1)){
                return dp[n][m] = sol(s1,s2,n-1,m-1,dp);
            }else{
                int insert = sol(s1,s2,n,m-1,dp);
                int replace = sol(s1,s2, n-1,m-1,dp);
                int delete = sol(s1,s2,n-1,m,dp);
                
                dp[n][m] = Math.min(insert, Math.min(replace, delete)) + 1;
            }
            return dp[n][m];
            
        }

        public static void main(String[] args) {
            EditDistance ed = new EditDistance();
            String word1 = "horse";
            String word2 = "ros";
            int Ans = ed.minDistance(word1, word2);

            System.out.println(Ans);
        }
    }
