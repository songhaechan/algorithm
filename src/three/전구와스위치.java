package three;

import java.io.*;
import java.util.StringTokenizer;

public class 전구와스위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        int[] input = new int[n];
        int[] expect = new int[n];

        // 0을 킨 경우
        int[] zeroOn = new int[n];
        // 0을 끈 경우
        int[] zeroOff = new int[n];

        st = new StringTokenizer(br.readLine());
        String pre = st.nextToken();
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(pre.substring(i,i+1));
            zeroOn[i] = Integer.parseInt(pre.substring(i,i+1));
            zeroOff[i] = Integer.parseInt(pre.substring(i,i+1));
        }

        // 0번째 전구를 킨 경우 세팅
        zeroOn[0] = 1 - zeroOn[0];
        zeroOn[1] = 1 - zeroOn[1];

        st = new StringTokenizer(br.readLine());
        String after = st.nextToken();
        for (int i = 0; i < n; i++) {
            expect[i] = Integer.parseInt(after.substring(i,i+1));
        }

        int zeroOnCnt = 1;
        int zeroOffCnt = 0;

        //0을 킨 경우
        for (int i = 1; i < n; i++) {
            if(expect[i-1] != zeroOn[i-1]){
                zeroOn[i-1] = 1 - zeroOn[i-1];
                zeroOn[i] = 1 - zeroOn[i];
                zeroOnCnt++;
                if(i != n-1){
                    zeroOn[i+1] = 1 - zeroOn[i+1];
                }
            }

            if(expect[i-1] != zeroOff[i-1]){
                zeroOff[i-1] = 1 - zeroOff[i-1];
                zeroOff[i] = 1 - zeroOff[i];
                zeroOffCnt++;
                if(i != n-1){
                    zeroOff[i+1] = 1 - zeroOff[i+1];
                }
            }
        }

        if(zeroOn[n-1] != expect[n-1]){
            zeroOnCnt = Integer.MAX_VALUE;
        }
        if(zeroOff[n-1] != expect[n-1]){
            zeroOffCnt = Integer.MAX_VALUE;
        }

        // 둘 다 기대값과 다르면 -1
        if(zeroOnCnt == Integer.MAX_VALUE && zeroOffCnt == Integer.MAX_VALUE){
            bw.write(-1+"\n");
        }else{
            bw.write(Math.min(zeroOnCnt,zeroOffCnt)+"\n");
        }

        bw.flush();
        bw.close();
    }
}
