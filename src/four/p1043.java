package four;

import java.io.*;
import java.util.*;

public class p1043 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, total = 0;
    static boolean[] truePeople = new boolean[51];
    static int[] parent;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수

        // union-find 초기화
        parent = new int[N+1];
        for(int i=1;i<=N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++) {
            truePeople[Integer.parseInt(st.nextToken())] = true;
        }

        ArrayList<Integer>[] peoples = new ArrayList[M];
        for(int i=0; i<M; i++) {
            peoples[i] = new ArrayList<>();
        }
        int value, pre =0;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }
            for(int j=1; j<n; j++) {
                value = Integer.parseInt(st.nextToken());
                peoples[i].add(value);
                union(pre, value);
                pre = value;
            }
        }

        int parent;
        // 진실을 아는 사람의 루트도 진실을 아는 사람
        for(int i=1; i<truePeople.length; i++) {
            if(truePeople[i]) {
                truePeople[find(i)] = true;
            }
        }

        for(int i=0; i<M; i++) {
            if(peoples[i].size() > 0) {
                // union 으로 다 묶었기때문에 한 명만 검사해도 됨 (모두 부모가 같음)
                parent = find(peoples[i].get(0));
                // 거짓말 가능
                if(!truePeople[parent]) total++;
            }
        }

        System.out.println(total);
    }

    private static int find(int x) {
        if(parent[x] == x)
            return parent[x] = x;
        else  return find(parent[x]);

    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!= b) {
            if(a>b) {
                parent[a] = b;
            } else {
                parent[b] = a;
            }
            return true;
        }
        return false;
    }
}

