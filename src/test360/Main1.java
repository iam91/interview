package test360;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        for (int i = 0; i < t; i++){
            int ret = 0;
            int n = scan.nextInt();

            for (int j = 0; j < n; j++){
                int[] temp = new int[4];
                for (int k = 0; k < 4; k++){
                    temp[k] = scan.nextInt();
                }

                ret += Math.abs(temp[2] - temp[0] + 1) * Math.abs(temp[3] - temp[1] + 1);
            }
            System.out.println(ret);

        }
    }
}
