import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        int index = 0;
        for(String s : br.readLine().split(" ")){
            arr[index] = Integer.parseInt(s);
            index++;
        }

        dp[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }
        int max = -1001;
        for(int i = 0; i < arr.length; i++){
            if(dp[i] > max)max = dp[i];
        }
        System.out.println(max);
    }

}

