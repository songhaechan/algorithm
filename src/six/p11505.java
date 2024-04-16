package six;

import java.io.*;
import java.util.StringTokenizer;

public class p11505 {
    static long[] tree;
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int treeHeight = (int) Math.ceil(Math.log(n)/Math.log(2));
        int treeSize = (int) Math.pow(2,treeHeight+1);
        int leafNodeStart = treeSize / 2;
        tree = new long[treeSize];

        for (int i = 0; i < treeSize; i++) {
            tree[i] = 1;
        }

        for (int i = leafNodeStart; i <leafNodeStart+n ; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Integer.parseInt(st.nextToken());
        }

        initTree(treeSize-1);

        for (int i = 0; i <m+k ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int leftTreeIndex = leafNodeStart + b - 1;
            long c = Integer.parseInt(st.nextToken());
            long rightTreeIndex = leafNodeStart + c - 1;
            if(a==1){
                changeValue(leftTreeIndex,(int)c);
            }
            if(a == 2){
                long result = getResult(leftTreeIndex, (int)rightTreeIndex);
                System.out.println(result);
            }
        }

        bw.flush();
        bw.close();
    }
    static void initTree(int x){
        while(x>1){
            tree[x/2] = tree[x]*tree[x-1]%mod;
            x -= 2;
        }
    }
    static void changeValue(int index, long newValue){
        tree[index] = newValue;
        while(index > 1){
            index /= 2;
            tree[index] = tree[index*2] % mod * tree[index*2 + 1] % mod;
        }
    }
    static long getResult(int s, int e){
        long result = 1;
        while(s<=e){
            if(s%2 == 1){
                result = result * tree[s] % mod;
                s++;
            }
            s = s / 2;
            if(e%2 == 0){
                result = result * tree[e] % mod;
                e--;
            }
            e = e / 2;
        }
        return result;
    }

}
