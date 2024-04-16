package one;

import org.w3c.dom.Node;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 최소값_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 출력 데이터가 많기 때문에 버퍼에 모아서 출력
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // TODO ArrayDeque 도 Deque 의 구현체 차이점 알아보자
        Deque<Node> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(stringTokenizer.nextToken());

            // 큐가 비어있지 않고 (비어있으면 removeLast 가 NoSuchEle 예외발생), 마지막 값이 새로들어온 값보다 크면!! 제거
            while(!deque.isEmpty() && deque.getLast().value > now){
                deque.removeLast();
            }
            // 새 노드 추가
            deque.addLast(new Node(now,i));
            // 범위 벗어난 값
            if(deque.getFirst().index + L <= i){
                deque.removeFirst();
            }
            bufferedWriter.write(deque.getFirst().value + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.index=index;
            this.value=value;
        }
    }
}
