import java.util.*;


public class Main {
    public static int[][] paintCost;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int paintCostLength = sc.nextInt();
        
        paintCost = new int[paintCostLength][3];

        for(int i = 0; i < paintCostLength; i++){
            for(int j = 0; j < 3; j++)paintCost[i][j] = sc.nextInt();
        }

        int[][] dp = new int[paintCostLength][paintCostLength];

        dp[0][0] = paintCost[0][0];
        dp[0][1] = paintCost[0][1];
        dp[0][2] = paintCost[0][2];

        
        for(int i = 1; i < paintCostLength; i++){
            dp[i][0] += Math.min(dp[i - 1][1], dp[i-1][2]) + paintCost[i][0];
            dp[i][1] += Math.min(dp[i - 1][0], dp[i-1][2]) + paintCost[i][1];
            dp[i][2] += Math.min(dp[i - 1][0], dp[i-1][1]) + paintCost[i][2];
        }

        int minCost = dp[paintCostLength - 1][0];

        for(int i = 1; i < 3; i++){
            if(minCost > dp[paintCostLength - 1][i]) minCost = dp[paintCostLength - 1][i];
        }
        System.out.println(minCost);
    }
}
