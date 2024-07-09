package _1st;

class WordSearch {
    static int[] x = {1,-1,0,0};
    static int[] y = {0,0,1,-1};
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i=0;i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                boolean[][] isVisited = new boolean[board.length][board[0].length];
                if(board[i][j] == words[0]){
                    if(backtrack(0,i,j,board,words,isVisited)) return true;
                }
            }
        }
        return false;
    }
    public boolean backtrack(int count,int m,int n,char[][] board, char[] words,boolean[][] isVisited){
        if(count+1 == words.length){
            return true;
        }
        for(int i=0; i<4;i++){
            int xp = m+x[i];
            int yp = n+y[i];
            if(xp<=board.length-1 && yp<=board[0].length-1 && xp>=0 && yp>=0 && !isVisited[xp][yp]){
                if(words[count+1] == board[xp][yp]){
                    isVisited[xp][yp] = true;
                    if(backtrack(count+1,xp,yp,board,words,isVisited)) return true;
                    isVisited[xp][yp] = false;
                }
            }
        }
        return false;
    }
}
