package programers;

class TargetNumber {
    static int count = 0;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        dfs(numbers,0,target,0);
        return count;
    }

    public void dfs(int[] numbers,int sum,int target,int depth){
        if(numbers.length == depth){
            if(sum == target) count++;
            return;
        }

        for(int i=0; i<2; i++){
            if(visited[depth]) continue;
            visited[depth] = true;
            if(i == 0){
                sum += numbers[depth];
            }else{
                sum -= numbers[depth];
            }
            dfs(numbers,sum,target,depth+1);
            if(i == 0){
                sum -= numbers[depth];
            }else{
                sum += numbers[depth];
            }
            visited[depth] = false;
        }
    }
}