import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;

        n = sc.nextInt();
        ArrayList<Integer> visit = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            visit.add(i);
        }
        for(int i = 1; i <= n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> visitList = new ArrayList<>(visit);
            list.add(i);
            visitList.remove(i-1);
            printNumber(n, list, visitList);
        }
    }

    public static void printNumber(int n, ArrayList<Integer> numberList, ArrayList<Integer> visitList){
        if(numberList.size() == n){
            for(Integer i : numberList){
                System.out.printf(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= visitList.size(); i++){

            ArrayList<Integer> newList = new ArrayList<>(numberList);
            newList.add(visitList.get(i-1));

            ArrayList<Integer> newVisit = new ArrayList<>(visitList);
            newVisit.remove(i-1);

            printNumber(n, newList, newVisit);

        }
    }

}
