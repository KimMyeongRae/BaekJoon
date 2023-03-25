import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][];
        int[][] dp = new int[n][];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            String[] val = str.split(" ");
            dp[i] = new int[val.length];
            triangle[i] = new int[val.length];
            for(int j = 0; j < val.length; j++)triangle[i][j] = Integer.parseInt(val[j]);
        }

        dp[0][0] = triangle[0][0];
        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++) {
                /*
                가장 앞 자리일때.
                중간자리 일때.
                가장 큰 자리일때
                 */
                if(j == 0){
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }else if(j+1 == triangle[i].length){
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        int max = 0;
        for(int i = 0; i < dp[dp.length - 1].length; i++){
            if(max < dp[dp.length - 1][i]) max =  dp[dp.length - 1][i];
        }
        System.out.println(max);
    }

}

