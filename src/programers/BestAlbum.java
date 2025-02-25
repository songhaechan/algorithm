package programers;

import java.util.*;

class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String,Integer> map = new HashMap();
        Map<String,PriorityQueue<Play>> pMap = new HashMap();
        List<Integer> result = new ArrayList();
        PriorityQueue<Genre> gpa = new PriorityQueue(Comparator.comparing(Genre::getTotal,Collections.reverseOrder()));

        for(int i=0; i<plays.length; i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
            if(pMap.containsKey(genres[i])){
                PriorityQueue<Play> pq = pMap.get(genres[i]);
                pq.offer(new Play(i,plays[i]));
            }else{
                PriorityQueue<Play> tmp = new PriorityQueue<Play>(Comparator.comparing(Play::getPlays,Collections.reverseOrder()).thenComparing(Play::getIndex));
                tmp.offer(new Play(i,plays[i]));
                pMap.put(genres[i],tmp);
            }
        }

        for(Map.Entry<String,Integer> e : map.entrySet()){
            gpa.offer(new Genre(e.getKey(),e.getValue()));
        }


        while(!gpa.isEmpty()){
            Genre g = gpa.poll();
            PriorityQueue<Play> pq = pMap.get(g.getName());
            int count = 0;
            while(!pq.isEmpty()){
                if(count >= 2){
                    break;
                }
                Play p = pq.poll();
                result.add(p.getIndex());
                count++;
            }
        }

        int[] answer = new int[result.size()];

        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    static class Play{
        int index;
        int plays;

        Play(int index, int plays){
            this.index = index;
            this.plays = plays;
        }

        public int getIndex(){
            return index;
        }

        public int getPlays(){
            return plays;
        }
    }

    static class Genre{
        String name;
        int total;

        public String getName(){
            return this.name;
        }

        public int getTotal(){
            return this.total;
        }

        Genre(String name, int total){
            this.name = name;
            this.total = total;
        }
    }
}