import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Boolean> map = new HashMap<>();


        for(int i = 0; i < n; i++){
            map.put(sc.next(), false);
        }


        for(int i = 0; i < m; i++){
            String name = sc.next();

            if(map.get(name) != null){
                map.put(name, true);
            }
        }

        ArrayList<String> list = new ArrayList<String>();

        for(String key : map.keySet()){
            if(map.get(key))list.add(key);
        }

        System.out.println(list.size());

        Collections.sort(list);

        for(String s : list) System.out.println(s);
    }
}