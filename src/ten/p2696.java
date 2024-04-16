package ten;

import java.io.*;
import java.util.*;

public class p2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        List<Integer> list;
        int cnt;

        for (int i = 0; i < T; i++) {
            cnt = 0;
            st = new StringTokenizer(br.readLine());
            list = new ArrayList<>();
            int M = Integer.parseInt(st.nextToken());
            // 중앙값 개수
            sb.append((M / 2 + 1)).append("\n");
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                cnt++;
                list.add(Integer.valueOf(st.nextToken()));
                Collections.sort(list);
                if(j%2 == 1){
                    sb.append(list.get(j / 2)).append(" ");
                }
                if(j%10 == 0){
                    st = new StringTokenizer(br.readLine());
                    if(j%20 == 0){
                        sb.append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
