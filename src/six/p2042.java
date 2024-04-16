package six;

import java.io.*;
import java.util.StringTokenizer;

public class p2042 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        // 세그먼트의 리프노드 개수
        int n = Integer.parseInt(st.nextToken());
        // 리프노드의 변경 횟수
        int m = Integer.parseInt(st.nextToken());
        // 질의 횟수
        int k = Integer.parseInt(st.nextToken());
        int treeHeight = (int) Math.ceil(Math.log(n)/Math.log(2));

        int treeSize = (int) Math.pow(2,treeHeight+1);
        int leftNodeStartIndex = treeSize / 2 - 1;

        tree = new long[treeSize+1];
        for (int i = leftNodeStartIndex+1; i <= leftNodeStartIndex + n; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }
        initTree(treeSize-1);

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());
            if(a == 1){
                change(leftNodeStartIndex+s,e);
            }else if (a==2){
                s = s + leftNodeStartIndex;
                e = e + leftNodeStartIndex;
                System.out.println(getSum(s,(int)e));
            }else{
                return;
            }
        }
    }
    static long getSum(int s, int e){
        long sum = 0;
        while(s<=e){
            if(s%2 == 1){
                sum = sum + tree[s];
                s++;
            }
            if(e%2==0){
                sum = sum + tree[e];
                e--;
            }
            s = s / 2;
            e = e / 2;
        }
        return sum;
    }
    static void change(int index , long value){
        // 차이만큼 계속 업데이트
        long diff = value - tree[index];
        while(index>0){
            tree[index] = tree[index] + diff;
            index = index / 2;
        }

    }
    static void initTree(int i){
        while(i != 1){
            tree[i/2] += tree[i];
            i--;
        }
    }
}
