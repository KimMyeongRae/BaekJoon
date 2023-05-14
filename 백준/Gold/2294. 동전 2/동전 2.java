import java.io.*;
import java.util.*;
public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        int[] dp = new int[10001];
        int[] coin = new int[n];

        for(int i = 0; i < n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= 10000; i++)dp[i] = 10001;

        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = coin[i]; j <= k; j++){
                dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
            }
        }

        if(dp[k] == 10001) System.out.println(-1);
        else System.out.println(dp[k]);

    }





}
