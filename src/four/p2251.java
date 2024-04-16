package four;

import java.util.*;
public class p2251 {

    public static class Water{
        int a, b, c;
        public Water(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static ArrayList<Integer> ansList;
    static int capaA, capaB, capaC;
    static boolean[][][] visited = new boolean[201][201][201];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ansList = new ArrayList<>();

        capaA = sc.nextInt();
        capaB = sc.nextInt();
        capaC = sc.nextInt();

        bfs();
        Collections.sort(ansList);
        for(int i = 0; i<ansList.size(); i++){
            System.out.print(ansList.get(i) + " ");
        }System.out.println();
    }

    public static void bfs(){

        Queue<Water> que = new LinkedList<Water>();
        que.add(new Water(0,0,capaC)); //초기 값 셋팅 (처음엔 C만 차 있음)

        while(!que.isEmpty()){
            Water water = que.poll();
            int a= water.a;
            int b = water.b;
            int c = water.c;
            if(visited[a][b][c] == true) continue;

            visited[a][b][c] = true;
            if(a==0) ansList.add(c);

            // 물 옮기기. 물이 넘칠 때와 넘치지 않을 때 각각 나눠서
            //A -> B
            if(a + b >= capaB){ que.add(new Water(a-(capaB-b), capaB, c));}
            else { que.add(new Water(0, a+b, c)); }
            //A -> C
            if(a + c >= capaC) { que.add(new Water(a-(capaC-c), b, capaC));}
            else { que.add(new Water(0, b, a+c)); }
            //B -> A
            if(b + a >= capaA){ que.add(new Water(capaA, b-(capaA-a), c)); }
            else { que.add(new Water(b+a, 0, c)); }
            //B -> C
            if(b + c >= capaC){ que.add(new Water(a, b-(capaC-c), capaC)); }
            else { que.add(new Water(a, 0, b+c)); }
            //C -> A
            if(c + a >= capaA) { que.add(new Water(capaA, b, c-(capaA-a)));}
            else{ que.add(new Water(a+c, b, 0)); }
            //C -> B
            if(c + b >= capaB) { que.add(new Water(a, capaB, c-(capaB-b)));}
            else{ que.add(new Water(a, b+c, 0)); }
        }

    }

}