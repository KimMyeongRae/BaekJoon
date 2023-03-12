import java.util.*;


public class Main {
    public static int[] returnCount = new int[3];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;


        n = sc.nextInt();


        int[][] map = new int[n][n];


        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                map[i][j] = sc.nextInt();
            }
        }

        cutPaper(0,0, n, map);

        for(int i = 0; i < 3; i++) System.out.println(returnCount[i]);
    }
    public static void cutPaper(int y, int x, int len, int [][] map){
        if(checkMap(y,x,len,map)){
            return;
        }


        int newSize =  len/3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cutPaper(y + (newSize * i), x + (newSize * j), newSize, map);
            }
        }
    }
    public static boolean checkMap(int y, int x, int max, int[][] map){

        int number = map[y][x];

        if(max != 1) {
            for (int i = y; i < y + max; i++) {
                for (int j = x; j < x + max; j++) {
                    if (map[i][j] != number) return false;
                }
            }
        }

        if(number == -1) returnCount[0]++;
        else if(number == 0)returnCount[1]++;
        else returnCount[2]++;

        return true;
    }

}
