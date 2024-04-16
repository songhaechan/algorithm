package four;

import java.io.*;
import java.util.*;

public class p1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int[] time = new int[n+1];

        List<Integer>[] list = new List[n+1];
        for (int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(true){
                int next = Integer.parseInt(st.nextToken());
                if(next == -1){
                    break;
                }
                list[next].add(i);
            }
        }

        int[] inDegree = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                inDegree[list[i].get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        int[] result = new int[n+1];

        while(!q.isEmpty()){
            Integer elem = q.poll();
            for (int i = 0; i < list[elem].size(); i++) {
                Integer next = list[elem].get(i);
                result[next] = Math.max(result[next],result[elem]+time[elem]);
            }
            for(int next : list[elem]){
                inDegree[next]--;
                if(inDegree[next]==0){
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            result[i] += time[i];
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(result[i]).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
