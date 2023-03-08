import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        boolean[][] map = new boolean[n][n];


        String[] friendRelation = new String[n];
        for(int i = 0; i < n; i++){
            friendRelation[i] = sc.nextLine();
            for(int j = 0; j < n; j++){
                map[i][j] = false;
            }
        }


        int max = 0;
        for(int i = 0; i < n; i++){
            int temp = 0;
            for(int j = 0; j < n; j++){
                if(i != j && friendRelation[i].charAt(j) == 'Y'){
                    temp++;
                    map[i][j] = true;
                    for(int k = 0; k < n; k++){
                        if(i != k && friendRelation[j].charAt(k) == 'Y' && !map[i][k]) {
                            temp++;
                            map[i][k]=true;
                        }
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j])count++;
            }
            if(count > max) max = count;
            count = 0;
        }

        System.out.println(max);
    }
}
