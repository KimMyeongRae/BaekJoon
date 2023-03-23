import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;

        n = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            int  temp = Integer.parseInt(bf.readLine());
            if(temp == 0){
                if(!que.isEmpty()){
                    System.out.println(que.poll());
                }else
                    System.out.println(0);
            }else que.add(temp);
        }
    }
}
