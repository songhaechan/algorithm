package six;

import org.w3c.dom.Node;

import java.io.*;
import java.util.StringTokenizer;

public class p14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node root = new Node();
        while(n>0){
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            Node now = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                // 인덱스 자체가 문자임
                if(now.next[c-'a'] == null){
                    now.next[c-'a'] = new Node();
                }
                now = now.next[c-'a'];
                if(i == word.length()-1){
                    now.end=true;
                }
            }
            n--;
        }
        int count = 0;
        while (m > 0) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            Node now = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(now.next[c-'a'] == null){
                    break;
                }
                now = now.next[c-'a'];
                if(i == word.length()-1 && now.end){
                    count++;
                }
            }
            m--;
        }
        System.out.println(count);
    }
    static class Node{
        Node[] next = new Node[26];
        boolean end;
    }
}
