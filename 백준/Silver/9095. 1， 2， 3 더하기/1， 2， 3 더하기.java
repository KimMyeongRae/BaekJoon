import java.util.*;


public class Main {
    public static int count;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();


        for(int i = 0; i < loop; i++){
            count = 0;
            int n = sc.nextInt();
            for(int j = 1; j < 4; j++) getCount(j, n);
            System.out.println(count);
        }
    }
    public static void getCount(int n, int target){
        if(n > target) return;
        if(n == target){
            count++;
            return;
        }
        getCount(n + 1, target);
        getCount(n + 2, target);
        getCount(n + 3, target);
    }
}
