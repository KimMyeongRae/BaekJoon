import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static int[] dp;
    public static int maxCost;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }
        dp[0] = 0;
        dp[1] = arr[1];
        if(n > 1) dp[2] = arr[1] + arr[2];
        System.out.println(topDown(n));
    }
    public static int topDown(int n){
        if(dp[n] == 0 && n != 0){
            dp[n] = Math.max(topDown(n - 2), topDown(n - 3 ) + arr[n - 1] ) + arr[n];
        }
        return dp[n];
    }
}
