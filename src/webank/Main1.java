package webank;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++){

            String s = scan.nextLine();

            int len = s.length();
            if(len <= 10) {
                System.out.println(s);
            } else {
                System.out.println(s.charAt(0) + String.valueOf(len - 2) + s.charAt(len - 1));
            }

        }
    }
}
