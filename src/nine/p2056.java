package nine;

import java.io.*;
import java.util.*;

public class p2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int[] inDegree = new int[n+1];
        int[] time = new int[n+1];
        int[] result = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            result[i] = time[i];
            int numberOfPreJob = Integer.parseInt(st.nextToken());
            for (int j = 0; j <numberOfPreJob ; j++) {
                int preJob = Integer.parseInt(st.nextToken());
                // 진입차수 설정
                inDegree[i]++;
                list.get(preJob).add(i);
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if(inDegree[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int now = que.poll();
            for(int next : list.get(now)){
                inDegree[next]--;
                result[next] = Math.max(result[next],result[now]+time[next]);
                if(inDegree[next]==0){
                    que.offer(next);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, result[i]);
        }

        System.out.println(ans);
    }
}
