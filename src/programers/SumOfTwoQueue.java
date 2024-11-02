package programers;

public class SumOfTwoQueue {
    public static void main(String[] args) {

    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        long sumOfQue1 = 0;
        long sumOfQue2 = 0;

        for(int i=0; i<queue1.length; i++){
            sumOfQue1 += queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            sumOfQue2 += queue2[i];
        }

        if(sumOfQue1 < sumOfQue2){
            answer = sumation(queue1,queue2,sumOfQue1, sumOfQue2);
        }else if(sumOfQue1 == sumOfQue2){
            return 0;
        }else{
            answer = sumation(queue2,queue1,sumOfQue2,sumOfQue1);
        }
        return answer;

    }
    public int sumation(int[] queue1, int[] queue2, long sumOfQue1, long sumOfQue2){
        int[] que = new int[queue1.length+queue2.length];
        int answer = -1;
        long total = 0;

        for(int i=0; i<queue1.length; i++){
            que[i] = queue1[i];
        }
        for(int i=0; i<queue2.length; i++){
            que[i+queue1.length] = queue2[i];
        }

        int idx = queue1.length + queue2.length;

        total = sumOfQue1 + sumOfQue2;

        // odd => return -1
        if(total%2 == 1){
            return answer;
        }

        // even
        long target = total/2;

        // circle que pointer
        int front = 0;
        int rear = queue1.length-1;

        int count = 0;

        while(target != sumOfQue1){
            if(front>rear || rear>idx || front>idx){
                return -1;
            }
            if(target>sumOfQue1){
                sumOfQue1 += que[++rear%idx];
            }else if(target<sumOfQue1){
                sumOfQue1 -= que[front%idx];
                front++;
            }

            count++;
        }
        return count;
    }
}
