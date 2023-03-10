import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, String> findString = new HashMap<>();
        HashMap<String, Integer>findInteger = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String str = sc.next();
            findString.put(i, str);
            findInteger.put(str, i);
        }

        for(int i = 0; i < m; i++){
            String str = sc.next();

            int number = str.charAt(0) - '0';
            if(0 <= number && number < 10){
                System.out.println(findString.get(Integer.parseInt(str)));
            }else{
                System.out.println(findInteger.get(str));
            }
        }
    }
}