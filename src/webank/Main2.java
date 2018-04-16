package webank;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();


        List<Integer> prime = new ArrayList<Integer>();
        for (int i = 0; i <= n; i++) {
            if(isPrime(i)) prime.add(i);
        }

        int count = 0;
        for (int i = 0; i < prime.size(); i++) {
            int tmp = prime.get(i);
            int mul = tmp;
            while (tmp <= n) {
                count++;
                tmp = tmp * mul;
            }
        }
        // return count;
        System.out.println(count);
    }

    public static boolean isPrime(int a) {
        boolean flag = true;
        if (a < 2) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
