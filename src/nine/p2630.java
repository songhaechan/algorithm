package nine;

import java.io.*;
import java.util.StringTokenizer;

public class p2630 {
    static int[][] base;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        base = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                base[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideConquer(0,0,n);

        System.out.println(white);
        System.out.println(blue);

    }
    static void divideConquer(int x, int y, int size){
        if(colorCheck(x,y,size)){
            if(base[x][y] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = size/2;
        divideConquer(x,y,newSize);
        divideConquer(x+newSize,y,newSize);
        divideConquer(x + newSize, y + newSize, newSize);
        divideConquer(x,y+newSize,newSize);
    }

    static boolean colorCheck(int x, int y, int size){
        int color = base[x][y];
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(base[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }

}
