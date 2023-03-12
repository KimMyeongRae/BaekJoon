import java.util.*;


public class Main {
    public static String[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while(number != 0){
            numbers = new String[number]; for(int i = 0; i < number; i++) numbers[i] = sc.next();


            for(int i = 0; i < numbers.length - 5; i++){
                ArrayList<String> numberList = new ArrayList<>();
                numberList.add(numbers[i]);
                backTracking(i, numberList);
            }
            
            System.out.println();
            
            number = sc.nextInt();
        }

    }

    public static void backTracking(int x, ArrayList<String> number){
        if(number.size() == 6){
            for(int i = 0; i < 6; i++){
                System.out.printf(number.get(i));
                if(i != 5) System.out.printf(" ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= numbers.length - 5; i++){
            if(x + i >= numbers.length) break;

            ArrayList<String> newNumber = new ArrayList<>(number);
            newNumber.add(numbers[x+i]);

            backTracking(x + i, newNumber);
        }
    }




}
