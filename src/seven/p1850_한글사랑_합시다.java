package seven;

import java.io.*;
import java.util.StringTokenizer;

public class p1850_한글사랑_합시다 {
    public static void main(String[] args) throws IOException {
        BufferedReader 버퍼리더 = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer 스트링토크나이져 = new StringTokenizer(버퍼리더.readLine());
        long 가 = Long.parseLong(스트링토크나이져.nextToken());
        long 나 = Long.parseLong(스트링토크나이져.nextToken());
        long 큰값 = Math.max(가,나);
        long 작은값 = Math.min(가,나);
        long 결과 = 유클리드호제법(가, 나);
        while(결과>0){
            bw.write("1");
            결과--;
        }
        bw.flush();
        bw.close();
    }
    static long 유클리드호제법(long 큰값, long 작은값){
        if(작은값 == 0){
            return 큰값;
        } else{
            return 유클리드호제법(작은값,큰값%작은값);
        }
    }
}
