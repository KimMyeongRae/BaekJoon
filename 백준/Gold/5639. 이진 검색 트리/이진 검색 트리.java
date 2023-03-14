import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static ArrayList<Integer> numList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         numList = new ArrayList<>();

        while(true) {
            String n = br.readLine();
            if(n==null||n.equals("")) break;
            // 더이상의 인풋이 존재하지 않으면 break
            int number = Integer.parseInt(n);
            numList.add(number);
        }
        startNode(0, numList.size()-1);

    }

    public static void startNode(int start, int end){

        if(start > end)return;

        int mid = start + 1;
        while(mid <= end && numList.get(mid) < numList.get(start))
            mid++;

        startNode(start + 1, mid-1);
        startNode(mid, end);
        System.out.println(numList.get(start));
    }
}


class Node{
    public int left;
    public int right;

    public Node(){

    };
//    public  Node(int left){this.left = left;}
//    public Node(int left, int right){this.left = left; this.right = right;}

//    public String toString(){
//        return " left : " + left + " Right : " + right;
//    }
}

