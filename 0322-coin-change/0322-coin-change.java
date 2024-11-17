class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] ans = new int[amount+1];
        Arrays.fill(ans, amount+1);
        ans[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    ans[i] = Math.min(ans[i], 1 + ans[i-coins[j]]);
                }
            }
        }

        return ans[amount] != amount + 1 ? ans[amount] : -1;
    }
}