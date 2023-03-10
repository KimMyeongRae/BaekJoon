import java.util.*;


public class Main {
    public static Point[] move = {new Point(0, 0), new Point(0, 1), new Point(+1, 0), new Point(+1,1)};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt(); sc.nextLine();
        String[][] map = new String[n][n];

        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) + "";
            }
        }

        String[][] newMap = new String[n/2][n/2];
        int index = 0;
        int jIndex = 0;


        while(map.length >= 2) {
            index = 0;
            for (int x = 0; x < map.length; x += 2) {
                jIndex = 0;
                for (int y = 0; y < map.length; y += 2) {
                    newMap[jIndex][index] = toCompression(y, x, map);
                    jIndex++;
                }
                index++;
            }
            map = newMap;
            newMap = new String[map.length/2][map.length/2];
        }
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++) if(map[i][j] != null)System.out.printf("%s ",map[i][j]);
            System.out.println(" ");
        }


    }


    public static String toCompression(int y, int x, String[][] map){
        StringBuilder sb = new StringBuilder();
        int zeroCount = 0;
        int oneCount = 0;
        for(int i = 0; i < 4; i++){
            int ny = move[i].y + y;
            int nx = move[i].x + x;

            if(map[ny][nx].equals("0"))zeroCount++;
            else if(map[ny][nx].equals("1"))oneCount++;
            sb.append(map[ny][nx]);
        }

        if(zeroCount == 4)return "0";
        else if(oneCount == 4) return "1";

        else return "("+sb.toString()+")";
    }
}

class Point{
    public int y;
    public int x;

    public Point(int y, int x){
        this.y = y;
        this.x = x;
    }
}