class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        
        long sum = 0l;
        
        for(int i = 1; i <= count; i++){
            int k = price * i;
            sum += k;
        }
        
        answer = sum > money ? sum - money : 0;

        return answer;
    }
}