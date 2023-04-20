
import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());


        String[] numbers = br.readLine().split(" ");
        int[] arr = new int[n];
        int index = 0;
        for(String number : numbers){
            arr[index++] = Integer.parseInt(number);
        }
        dp = new int[n];
        dp[0] = arr[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            int temp = 0;
            for(int j = i-1; j >= 0; j--){
                if(arr[j] < arr[i] && dp[j] > temp) temp = dp[j];
            }
            dp[i] = temp + arr[i];
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }



}
