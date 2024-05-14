import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
            
        int xmax = 0;
        int ymax = 0;
        
        for(int i = 0; i < sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            xmax = Math.max(xmax, sizes[i][0]);
            ymax = Math.max(ymax, sizes[i][1]);
            
            
        }
        
        return xmax * ymax;
    }
}