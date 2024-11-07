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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 재귀를 반복하면서 자연히 min, max 값이 적절히 바뀜.
    // left는 부모보다 작아야하고, 부모가 right였다면 그 윗부모 보단 커야함
    // right는 부모보다 커야하고, 부모가 left였다면 그 윗부모 보단 작아야함
    // 위 두가지에 대응 가능한 재귀 함수임.
    private boolean isValidBST(TreeNode node, long min, long max){
        // 만약 null 이면 무조건 검사할 필요도 없으니 true 리턴 
        if(node == null){
            return true;
        }
        
        if(node.val <= min || node.val >= max){
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}