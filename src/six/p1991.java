package six;

import java.io.*;
import java.util.StringTokenizer;

public class p1991 {
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());

        tree = new int[26][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            if(left =='.'){
                tree[index][0] = -1;
            }else{
                tree[index][0] = left - 'A';
            }
            if(right == '.'){
                tree[index][1] = -1;
            }else{
                tree[index][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();

        bw.flush();
        bw.close();
    }
    static void preOrder(int x){
        if(x == -1){
            return;
        }
        System.out.print((char) (x + 'A'));
        preOrder(tree[x][0]);
        preOrder(tree[x][1]);
    }
    static void inOrder(int x){
        if(x == -1){
            return;
        }
        inOrder(tree[x][0]);
        System.out.print((char) (x + 'A'));
        inOrder(tree[x][1]);
    }
    static void postOrder(int x){
        if(x == -1){
            return;
        }
        postOrder(tree[x][0]);
        postOrder(tree[x][1]);
        System.out.print((char) (x + 'A'));
    }
}
