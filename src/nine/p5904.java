package nine;

import java.io.*;
import java.util.StringTokenizer;

public class p5904 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        findMoo(1,n);
        System.out.println();
    }

    static void findMoo(int k, int n){
        int size = 3;
        while (size < n) {
            size = (size * 2) + k + 3;
            k++;
        }
        k--;
        int preSize = size/2 - (k+3)/2;

        if(n == preSize+1){
            System.out.println("m");
        } else if (n <= preSize + k+3) {
            System.out.println("o");
        }else{
            findMoo(1,n - (preSize+k+3));
        }
    }
}
