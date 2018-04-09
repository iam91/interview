package jd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] N = new int[cnt];

        for(int i = 0; i < cnt; i++){
            N[i] = sc.nextInt();
            //
        }

        for(int i = 0; i < cnt; i++) {

            //
            if((N[i] & 0x01) > 0) {
                System.out.println("No");
                return;
            }
            int y = 2;
            while((N[i] % y) == 0) {
                y = y << 1;
            }
            System.out.println(N[i] * 2 / y + " " + y / 2);
        }
    }
}
