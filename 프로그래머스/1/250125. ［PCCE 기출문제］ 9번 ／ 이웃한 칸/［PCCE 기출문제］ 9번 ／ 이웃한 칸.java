import java.util.*;

class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        int n = board.length;
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++){
            int x = h + dh[i];
            int y = w + dw[i];
            if(0 <= x && x < n && 0<= y && y < n && board[x][y].equals(color)) answer++;
        }
        
        return answer;
    }
}