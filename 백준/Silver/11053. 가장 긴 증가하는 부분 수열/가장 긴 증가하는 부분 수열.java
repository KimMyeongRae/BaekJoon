import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int index = 1;

        for(String s : br.readLine().split(" ")){
            arr[index] = Integer.parseInt(s);
            index++;
        }
        int[] dp = new int[n+1];

        for(int i = 1; i < arr.length; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(arr[i] > arr[j]){
                    if(max < dp[j])max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        int max = -1;
        for(int i = 1; i < dp.length; i++){
            if(max < dp[i])max = dp[i];
        }
        System.out.println(max);

    }

}

