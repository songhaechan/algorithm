package six;

import java.io.*;
import java.util.StringTokenizer;

public class p10868 {
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 노드 개수
        int n = Integer.parseInt(st.nextToken());
        // 질의 개수
        int m = Integer.parseInt(st.nextToken());

        int treeHeight = (int) Math.ceil(Math.log(n)/Math.log(2));

        int treeSize = (int) Math.pow(2, treeHeight + 1);

        int leafNodeStart = treeSize / 2;

        tree = new int[treeSize];

        for (int i = 0; i < treeSize; i++) {
            tree[i] = Integer.MAX_VALUE;
        }

        for (int i = leafNodeStart; i < leafNodeStart+n; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Integer.parseInt(st.nextToken());
        }

        initTree(treeSize-1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int treeStartIndex = leafNodeStart + start - 1;
            int treeEndIndex = leafNodeStart + end - 1;
            int minValue = getMinValue(treeStartIndex, treeEndIndex);
            System.out.println(minValue);
        }


        bw.flush();
        bw.close();
    }

    static void initTree(int x){
        while(x>1){
            tree[x/2] = Math.min(tree[x],tree[x-1]);
            x -= 2;
        }
    }
    static int getMinValue(int s, int e){
        int result = Integer.MAX_VALUE;
        while(s<=e){
            if(s%2 == 1){
                result = Math.min(result,tree[s]);
                s++;
            }
            s = s / 2;
            if(e%2 == 0){
                result = Math.min(result,tree[e]);
                e--;
            }
            e = e / 2;
        }
        return result;
    }
}
