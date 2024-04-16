package seven;

import java.io.*;
import java.util.StringTokenizer;

public class p1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 테스트 케이스 수
        int n = Integer.parseInt(st.nextToken());
        int k = 2;
        int result = 0;
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int max = Math.max(a,b);
            int min = Math.min(a,b);
            result = max;
            while(result % min != 0){
                result = max * k;
                k++;
            }
            System.out.println(result);
            k=2;
            result=0;
        }
    }
}
