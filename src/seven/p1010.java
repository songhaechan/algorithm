package seven;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p1010 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long [] f = new long[21];
        boolean [] c = new boolean[21]; //n엔 중복된 수가 없으므로 중복을 없앨 boolean 배열
        Arrays.fill(f, 1);

        for(int i=1; i<=20; i++) { //팩토리얼 구하기
            f[i] = f[i-1]*i;
        }

        int n = scan.nextInt();
        int what = scan.nextInt();

        int [] a = new int[n];
        if(what == 2) { //몇 번째 순열인지
            for(int i=0; i<n; i++)
                a[i] = scan.nextInt();

            long ans = 1; //순열은 1 번째 부터 시작
            for(int i=0; i<n; i++) {
                for(int j=1; j<a[i]; j++) {
                    if(!c[j])
                        ans += f[n-i-1];
                }
                c[a[i]]=true;
            }
            System.out.println(ans);
        }
        else if(what == 1) { //k 번째 순열 출력
            long k = scan.nextLong();
            for(int i=0; i<n; i++) {
                for(int j=1; j<=n; j++) {
                    if(c[j])
                        continue;
                    if(f[n-i-1] < k) {
                        k -= f[n-i-1];
                    }
                    else {
                        a[i] = j;
                        c[j] = true;
                        break;
                    }
                }
            }
            for(int i=0; i<n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
