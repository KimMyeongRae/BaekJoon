import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static boolean[][] checkMap = new boolean[25][25];
    static int[][] map = new int[25][25];

    static ArrayList<Integer> result = new ArrayList<Integer>();

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        for(int i = 0; i < n; i++){
            String numLine = br.readLine();
            int index = 0;
            for(String number : numLine.split("")){
                map[i][index] = Integer.parseInt(number);
                index++;
            }
        }

        int nCount = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] > 0){find(i, j, nCount); nCount++;}
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public static void find(int y, int x, int nCount){

        Queue<Point> que = new LinkedList<>();


        int[] moveY = new int[]{0,0,1,-1};
        int[] moveX = new int[]{1,-1,0,0};
        que.add(new Point(y,x));
        int count = 0;
        while (!que.isEmpty()){
            int nY = que.peek().y;
            int nX = que.peek().x;
            if(map[nY][nX] > 0) {
                map[nY][nX] = -999;
                for (int i = 0; i < 4; i++) {
                    int mY = nY + moveY[i];
                    int mX = nX + moveX[i];
                    if (n > mY &&
                            n > mX &&
                            mY >= 0 &&
                            mX >= 0 &&
                            map[mY][mX] > 0) {
                        que.add(new Point(mY, mX));
                    }
                }
                count++;
            }
            que.remove();

        }
        result.add(count);
    }

}

class Point{
    int y;
    int x;

    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}