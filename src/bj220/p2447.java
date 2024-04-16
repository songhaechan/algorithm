package bj220;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2447 {
    static char[][] stars;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());

        stars = new char[n][n];

        recursive(0,0,n,false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recursive(int x,int y,int n, boolean blank){
        if(blank){
            for (int i = x; i <x+n; i++) {
                for (int j = y; j <y+n; j++) {
                    stars[i][j]=' ';
                }
            }
            return;
        }
        if(n==1){
            stars[x][y]='*';
            return;
        }

        int size = n/3;
        int count = 0;
        for (int i = x; i <x+n; i+=size) {
            for (int j = y; j <y+n; j+=size) {
                count++;
                if(count == 5){
                    recursive(i,j,size,true);
                }else{
                    recursive(i,j,size,false);
                }
            }
        }
    }
}
