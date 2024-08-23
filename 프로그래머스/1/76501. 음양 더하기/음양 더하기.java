class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;
        
        int sum = 0;
        
        for(int i = 0; i < absolutes.length; i++){
           sum += absolutes[i] * (signs[i] == true? 1:-1);
        }
        
        answer = sum;
        
        return answer;
    }
}