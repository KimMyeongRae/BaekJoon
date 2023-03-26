import java.util.*;
import java.io.*;
public class Main {
    public static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            map = new int[n+1][2];

            for(int j = 0; j <= n; j++){
                if(j == 0) map[j][0] = 1;
                else if(j == 1) map[j][1] = 1;
                else{
                    map[j][0] = map[j-1][0] + map[j-2][0];
                    map[j][1] = map[j-1][1] + map[j-2][1];
                }
            }
            System.out.println(map[n][0] + " " + map[n][1]);
        }


    }

}

