package programers;

import java.util.*;
class TempTest {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Gpa> list = new ArrayList();
        list.add(new Gpa(1,0));
        list.add(new Gpa(2,0));
        list.add(new Gpa(3,0));

        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%one.length]){
                list.get(0).increase();
            }
            if(answers[i] == two[i%two.length]){
                list.get(1).increase();
            }
            if(answers[i] == three[i%three.length]){
                list.get(2).increase();
            }
        }

        Collections.sort(list,Comparator.comparing(Gpa::getScore,Collections.reverseOrder()).thenComparing(Gpa::getId));

        for(int i=0; i<3; i++){
            System.out.println("id: "+list.get(i).getId()+" socre : "+ list.get(i).getScore());
        }

        int max= list.get(0).getScore();
        int count = 1;

        for(int i=1; i<3; i++){
            if(list.get(i).getScore() == max){
                count++;
            }
        }

        int[] result = new int[count];

        for(int i=0; i<count; i++){
            result[i] = list.get(i).getId();
        }
        return result;

    }
    static class Gpa{
        public int id;
        public int score;
        Gpa(int i , int s){
            this.id = i;
            this.score = s;
        }

        public int getScore(){
            return score;
        }

        public int getId(){
            return id;
        }

        public void increase(){
            score++;
        }

    }
}
