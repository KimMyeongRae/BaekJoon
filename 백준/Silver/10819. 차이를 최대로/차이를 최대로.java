import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int max = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;

        n = sc.nextInt();
        ArrayList<Integer> visit = new ArrayList<>();
        for(int i = 0; i < n; i++)
            visit.add(sc.nextInt());


        for(int i = 0; i < n; i++){
            ArrayList<Integer> nowVisit = new ArrayList<>(visit);
            ArrayList<Integer> numberList = new ArrayList<>();
            numberList.add(visit.get(i));
            nowVisit.remove(i);
            calculator(nowVisit, numberList, n);
        }

        System.out.println(max);

    }

    public static void calculator(ArrayList<Integer> visit, ArrayList<Integer> numberList, int n){
        if(numberList.size() == n){
            int result = 0;
//            System.out.println(numberList.toString());
            for(int i = 0; i < numberList.size()-1; i++) {
//                System.out.println(numberList.get(i) + " - " + numberList.get(i + 1));
                result += Math.abs(numberList.get(i) - numberList.get(i + 1));
            }
            if(result > max) max = result;
            return;
        }
        for(int i = 0; i < visit.size(); i++){
            ArrayList<Integer> newVisit = new ArrayList<>(visit);
            ArrayList<Integer> newNumberList = new ArrayList<>(numberList);
            newNumberList.add(newVisit.get(i));
            newVisit.remove(i);
            calculator(newVisit, newNumberList, n);
        }

    }

}
