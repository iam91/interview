package test360;

import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        for (int i = 0; i < t; i++){

            long[] temp = new long[3];

            for (int k = 0; k < 3; k++){
                temp[k] = scan.nextLong();
            }

            Arrays.sort(temp);

            if(temp[0] + temp[1] > temp[2] / 2) {
                System.out.println((temp[0] + temp[1] + temp[2]) / 3);
            } else {
                System.out.println(temp[0] + temp[1]);
            }
        }
    }
}
