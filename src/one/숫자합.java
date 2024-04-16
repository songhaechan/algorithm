package one;

import java.util.Scanner;

public class 숫자합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String numbers = scan.next();

        long total=0;
        for(int i=0; i<n; i++){
            total += (int)numbers.charAt(i) - 48;
        }

        System.out.println(total);

    }
}
