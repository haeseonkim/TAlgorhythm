class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        // i번 집을 털때 or 안털때에 대한 최댓값을 저장
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        // i번 집을 털때와 안털때 중 큰 값을 dp에 넣기
        // 점화식이 성립하는 이유.. 아래 처럼 두가지로 나누고 최대만 보면 됨
        // => i번 집을 안털 때 : dp[i-1]
        // => i번 집을 털 때 : nums[i] + dp[i-2]
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[n-1];
    }
}