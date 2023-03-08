import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] score = new int[n][3];

        for(int i = 0; i < n; i++){
            score[i][0] = sc.nextInt();
            score[i][1] = sc.nextInt();
            score[i][2] = sc.nextInt();
        }
        int result = 0;
        for(int i = 123; i <= 987; i++){
            int[] arr2 = {
                    i/100,
                    i/10 % 10,
                    i%10
            };
            boolean flg = false;
            for(int j = 0; j < 3; j++){
                if(arr2[j] == 0){flg = true; break;}
                for(int k = 0; k < 3; k++){
                    if( (j != k && arr2[j] == arr2[k])) {
                        flg = true;
                        break;
                    }
                }
            }
            if(flg)continue;

            int count = 0;
            for(int x = 0; x < n; x++){
                int ball = 0;
                int strike = 0;

                int[] arr = {
                        score[x][0]/100,
                        score[x][0]/10 % 10,
                        score[x][0] % 10
                };


                for(int q = 0; q < 3; q++){
                    if(arr[q] == arr2[q]) strike++;
                }
                for(int q = 0; q < 3; q++){
                    for(int w = 0; w < 3; w++){
                        if(arr[q] == arr2[w] && q != w)ball++;
                    }
                }
                if(score[x][1] == strike && score[x][2] == ball){
                    count++;
                }
            }
            if(count == n) result++;
        }
        System.out.println(result);


    }
}
