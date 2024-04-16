package nine;

import java.io.*;
import java.util.StringTokenizer;

public class p3019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[][][] blockInfo = {
                new int[][] {new int[]{0},new int[]{0,0,0}},
                new int[][] {new int[]{0}},
                new int[][] {new int[]{0,-1}, new int[]{1}},
                new int[][] {new int[]{1,0},new int[]{-1}},
                new int[][] {new int[]{0,0},new int[]{-1},new int[]{1},new int[]{1,-1}},
                new int[][] {new int[]{0,0}, new int[]{0},new int[]{2},new int[]{-1,0}},
                new int[][] {new int[]{0,0}, new int[]{0},new int[]{0,1},new int[]{-2}}
        };


        int[] height = new int[C];
        int[] heightDiff = new int[C-1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <C ; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <C-1 ; i++) {
            heightDiff[i] = height[i] - height[i+1];
        }

        int cnt = 0;

        for (int i = 0; i < blockInfo[P-1].length; i++) {
            for (int j = 0; j < C - blockInfo[P-1][i].length; j++) {
                if(P-1 == 0 && i==0){
                    cnt += C;
                    break;
                }
                boolean flag = true;
                for (int k = 0; k < blockInfo[P-1][i].length; k++) {
                    if(heightDiff[j+k] != blockInfo[P-1][i][k]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}
