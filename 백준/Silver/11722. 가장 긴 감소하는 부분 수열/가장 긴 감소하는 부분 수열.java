
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        String[] numS = br.readLine().split(" ");
        int index = 0;

        for(String s : numS)arr[index++] = Integer.parseInt(s);

        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for(int i = 1; i < arr.length; i++){

            for(int j = i-1; j >= 0; j--){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if(dp[i] == 0)dp[i] = 1;

            if(dp[i] > max) max = dp[i];
        }

        System.out.println(max);


    }

}
