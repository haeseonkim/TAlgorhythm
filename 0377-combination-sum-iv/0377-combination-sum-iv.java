class Solution {
    public int combinationSum4(int[] nums, int target) {
        // 인덱스 숫자가 되기 위한 구성 갯수를 저장하는 배열 
        int[] sumCount = new int[target+1]; // 선언만으로 모두 0으로 채워짐.
        sumCount[0] = 1;

        for(int sum = 1; sum <= target; sum++){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= sum){ // 요소가 target보다 작으면 구성요소가 될수 있음
                    // nums[i]를 첫번째 요소로 사용할 때의 구성 갯수 == sumCount[sum - nums[i]]
                    // why??? nums[i]를 첫번째 요소로 사용할때 갯수면 무조건 nums[i]는 사용하는거니까
                    // target-nums[i]의 구성요소 갯수와 같다.
                    // 구성을 보면 [nums[i](고정), ...target-nums[i]의 구성요소...]가 된다.
                    sumCount[sum] = sumCount[sum] + sumCount[sum - nums[i]];
                }
            }
        }

        return sumCount[target];
    }
}