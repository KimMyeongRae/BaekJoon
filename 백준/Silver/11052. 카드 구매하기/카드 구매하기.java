import java.io.*;

public class Main {
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        int[] cardPrice = new int[n + 1];
        int index = 1;

        for (String s : br.readLine().split(" ")){
            cardPrice[index] = Integer.parseInt(s);
            index++;
        }


        for(int i = 1; i <= n; i++){
            for(int j = i; j >= 1; j--) {
                dp[i] = Math.max(Math.max(dp[j] + cardPrice[i-j], dp[i]),cardPrice[i]);
            }
        }
        System.out.println(dp[n]);
    }
}



