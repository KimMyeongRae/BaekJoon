import java.io.*;
public class Main {
    public static int max = 0;
    public static int[] arr;
    public static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new Integer[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = arr[0];
        dp[1] = arr[1];
        if(n > 1) dp[2] = arr[1]+arr[2];

        System.out.println(findX(n));

    }


    public static int findX(int x){
        if(dp[x] == null){
            dp[x] = Math.max(
                    Math.max(findX(x - 2), findX(x - 3) + arr[x-1]) + arr[x],
                    findX(x - 1)
            );
        }

        return dp[x];
    }


}



