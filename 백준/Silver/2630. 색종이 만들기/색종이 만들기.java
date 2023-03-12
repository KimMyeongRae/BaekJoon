import java.util.*;


public class Main {
    public static int[][] map;
    public static int white = 0;
    public static int blue = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        map = new int[n][n];
        for(int i = 0; i < n; i++) for(int j = 0; j < n; j++) map[i][j] = sc.nextInt();

        cutPaper(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static boolean checkPaper(int y, int x, int size){
        int number = map[y][x];

        for(int i = y; i < y + size; i++)
            for(int j = x; j < x + size; j++)
                if(map[i][j]  != number) return false;

        if(number == 0)white++;
        else blue++;
        return true;
    }

    public static void cutPaper(int y,int x, int size){
        if(checkPaper(y,x,size)) return;

        int newSize = size/2;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                cutPaper(y + (i * newSize), x + (j * newSize), newSize);
            }
        }

    }

}
