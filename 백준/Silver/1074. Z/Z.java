import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int Y = sc.nextInt(); int X = sc.nextInt();

        n = (int)Math.pow(2,n);
        int count = 0;
        int size = 0;
        while(n != 1) {
            if(Y < n/2 && X < n/2){ // 1사분면
                n /= 2;
            }else if(Y < n/2 && n/2 <= X){ // 2사분면
                count += n*n/4;
                X -= n/2;
            }else if(n/2 <= Y && X < n/2){ // 3사 분면
                count += (n*n/4) * 2;
                Y -= n/2;
            }else { // 4사분면
                count += (n*n/4) * 3;
                X -= n/2; Y -= n/2;
            }
        }
        System.out.println(count);
    }
}