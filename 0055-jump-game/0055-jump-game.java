class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;

        // dp는 무조건 배열의 앞에서부터 찾아나간다고 생각했는데 
        // 여기선 최대 점프수가 주어지니까 골 지점 바로 앞에서시작해서 --하며 시작점까지 도달가능한지 역추적한다..
        // goal에 도달가능한 지점이면 goal해당 지점으로 업데이트한다.

        // 업데이트 되는 goal에 계속 도달가능해서 goal이 계속 앞으로 이동하면.
        // 거쳐온 모든 뒤의 인덱스들을 통해 무조건 마지막 지점에 도착할수 있으므로 젤 앞의(현재의) goal만 봐도 무방함.
        for(int i = nums.length-2; i >=0 ; i--){
            if(i + nums[i] >= goal){
                goal = i;
            }
        }

        // 첫번째 지점까지 왔으면 true;
        return goal == 0;
    }
}