import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String king = sc.next();
        String stone = sc.next();
        int n = sc.nextInt();

        int ky = king.charAt(0) - 'A';
        int kx = king.charAt(1) - '1';
        int sy = stone.charAt(0) - 'A';
        int sx = stone.charAt(1) - '1';
        int[][] map = new int[8][8];

        for(int i = 0; i < 8; i++) for(int j = 0; j < 8; j++) map[i][j] = 0;

        map[ky][kx] = 999;
        map[sy][sx] = -999;

        HashMap<String, Point> commandMap = new HashMap<String, Point>();

        commandMap.put("R", new Point(1, 0));
        commandMap.put("L", new Point(-1, 0));
        commandMap.put("B", new Point(0, -1));
        commandMap.put("T", new Point(0, 1));
        commandMap.put("RT", new Point(1, 1));
        commandMap.put("LT", new Point(-1, 1));
        commandMap.put("RB", new Point(1, -1));
        commandMap.put("LB", new Point(-1, -1));


        for(int i = 0; i < n; i++){
            String command = sc.next();
            Point p = commandMap.get(command);

            int ny = p.y + ky;
            int nx = p.x + kx;


            if(0 <= ny && ny < 8 && 0 <= nx && nx < 8){
                if(map[ny][nx] == -999){
                    int sny = ny + p.y;
                    int snx = nx + p.x;
                    if(!(0 <= sny && sny < 8 && 0 <= snx && snx < 8)) continue;
                    map[sny][snx] = -999;
                    sy = sny;
                    sx = snx;
                }
                map[ny][nx] = 999;
                map[ky][kx] = 0;
                ky = ny;
                kx = nx;
            }
        }


//        System.out.println("king : y " + ky + " x " + kx);
        System.out.println((char)(ky + 'A' ) + "" + (char)(kx + '1'));
//        System.out.println("stone : y " + sy + " x " + sx);
        System.out.println((char)(sy + 'A' ) + "" + (char)(sx + '1'));
    }
}
class Point{
    public int y;
    public int x;

    public Point(int y, int x){this.y = y; this.x = x;}
}