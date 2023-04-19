import java.io.*;
import java.util.*;

public class Main {
    static int n;

    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());



        for(int t = 0; t < testCase; t++){

            n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];

            for(int i = 0; i < 2; i++){
                int index = 0;
                for (String number : br.readLine().split(" ")) {
                    arr[i][index++] = Integer.parseInt(number);
                }

            }

            dp = new int[2][n];

            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            int result = Math.max(dp[0][0], dp[1][0]);
            int max = 0;
            for(int i = 1; i < n; i++){ // x


                dp[0][i] = Math.max(max, dp[1][i-1]) + arr[0][i];
                if(dp[0][i] > result) result = dp[0][i];

                dp[1][i] = Math.max(max, dp[0][i-1]) + arr[1][i];
                if(dp[1][i] > result) result = dp[1][i];

                max = Math.max(dp[0][i-1], dp[1][i-1]);

            }

//            for(int i = 0; i < 2; i++){
//                for(int j = 0; j < n; j++){
//                    System.out.print(dp[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println(result);
        }


    }



}
