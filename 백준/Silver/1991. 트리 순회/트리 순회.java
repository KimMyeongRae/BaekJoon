import java.util.*;


public class Main {
    public static HashMap<Character, Node> map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        map = new HashMap<Character, Node>();


        for(int i = 0; i < n; i++){
            map.put(sc.next().charAt(0), new Node(sc.next().charAt(0), sc.next().charAt(0)));
        }
        frist('A');
        System.out.println();
        second('A');
        System.out.println();
        third('A');
    }

    public static void frist(char c){
        Node n = map.get(c);
        if(n == null) return;
        System.out.printf("%c",c);

        if(n.left != '.')frist(n.left);
        if(n.rigth != '.')frist(n.rigth);
    }

    public static void second(char c){
        Node n = map.get(c);
        if(n == null) return;

        if(n.left != '.')second(n.left);
        System.out.printf("%c",c);
        if(n.rigth != '.')second(n.rigth);
    }
    public static void third(char c){
        Node n = map.get(c);
        if(n == null) return;

        if(n.left != '.')third(n.left);
        if(n.rigth != '.')third(n.rigth);
        System.out.printf("%c",c);
    }
}
class Node{
    public char left;
    public char rigth;

    public Node(char left, char rigth){
        this.left = left;
        this.rigth = rigth;
    }
}
