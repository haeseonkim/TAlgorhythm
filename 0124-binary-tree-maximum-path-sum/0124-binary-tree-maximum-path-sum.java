/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        
        int[] maximum = new int[1];

        // 재귀속에서 합을 계속 들고다니기 위해 배열에 넣어둠.
        maximum[0] = Integer.MIN_VALUE;

        findMaxPathSum(root, maximum);
        
        return maximum[0];
    }

    private int findMaxPathSum(TreeNode root, int[] maximum){
        if(root == null) return 0;

        int leftSum = Math.max(0, findMaxPathSum(root.left, maximum));

        int rightSum = Math.max(0, findMaxPathSum(root.right, maximum));

        // 현재 노드인 root를 가장 높은 노드로 할 경우의 값과 전체 최댓값을 비교해서
        // 전체 최댓값 갱신
        maximum[0] = Math.max(maximum[0], leftSum + rightSum + root.val);

        // left, right 중 더 큰값과 root를 합한 값을 리턴
        // root까지의 최대값임.
        return root.val + Math.max(leftSum, rightSum);
    }
}