class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        int cola = n;
        while(cola>= a){
            int next = cola/a;
            int remain = cola%a;
            int get = next * b;
            answer += get;
            cola = get + remain;
        }
        
        return answer;
    }
}