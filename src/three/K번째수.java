package three;

import java.io.*;
import java.util.StringTokenizer;

public class K번째수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = k;
        while(start <= end){
            int cnt = 0;
            int mid = (start + end) /2;
            for (int i = 1; i < n+1; i++) {
                cnt += Math.min(mid / i, n);
            }
            if(cnt >= k){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        bw.write(start+"\n");


        bw.flush();
        bw.close();
    }
}
