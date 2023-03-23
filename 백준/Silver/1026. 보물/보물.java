import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();


        for(String s : br.readLine().split(" "))A.add(Integer.parseInt(s));
        Collections.sort(A);
        for(String s : br.readLine().split(" "))B.add(Integer.parseInt(s));
        B.sort(Collections.reverseOrder());
        int result = 0;
        for(int i = 0; i < A.size(); i++){
            result += A.get(i) * B.get(i);
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

}
