import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        BigInteger temp = new BigInteger("1");
        for(long i = 1; i <= n; i++){
            temp = temp.multiply(BigInteger.valueOf(i));
        }

        if(Integer.parseInt(temp.mod(BigInteger.valueOf(10)).toString()) > 0) {System.out.println(0); return;}
        int count = 0;
        while(temp.toString().length() > 0){
            temp = temp.divide(BigInteger.valueOf(10));
            count++;
            if(Integer.parseInt(temp.mod(BigInteger.valueOf(10)).toString()) % 10 > 0) {System.out.println(count); return;}
        }

    }
}
