import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();


        ArrayList<Integer> numList = new ArrayList<>();
        String[] str2 = str.split("-");

        for(String str3 : str2) {
            String[] str4 = str3.split("\\+");
            int temp = 0;
            for(String str5 : str4){
                temp += Integer.parseInt(str5);
            }

            numList.add(temp);
        }

        int result = 0;
        if(str.charAt(0) == '-'){
            for(Integer i : numList) result -= i;
        }else{
            result += numList.get(0);
            for(int i = 1; i < numList.size(); i++){
                result -= numList.get(i);
            }
        }


        System.out.println(result);
    }
}