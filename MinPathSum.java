//Question 64 Leetcode.com
import java.util.Arrays; // for IDE
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return minCost(grid,0,0,grid.length-1,grid[0].length-1,dp);
    }
    
    public int minCost(int[][] grid,int cr,int cc,int er,int ec, int[][] dp){
        
        if(cr<0 ||cr > er || cc<0 || cc > ec){
            return Integer.MAX_VALUE;
        }
        
        if(cr==er && cc==ec){
            return grid[cr][cc];
        } 
        
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }
        int right = minCost(grid,cr,cc+1,er,ec,dp);
        int down = minCost(grid,cr+1,cc,er,ec,dp);
        
        dp[cr][cc] = Math.min(right,down) + grid[cr][cc];
        return dp[cr][cc];
    }
}