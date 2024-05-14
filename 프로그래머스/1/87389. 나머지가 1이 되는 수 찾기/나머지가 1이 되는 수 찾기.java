class Solution {
    public int solution(int n) {
        
        int x = 1;
        while(x <= n){
            if(n % x == 1) break;
            x++;
        }
        
        return x;
    }
}