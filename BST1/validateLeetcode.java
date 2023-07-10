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

    public class Pair{
        boolean isBst;
        long  mini;
        long  maxi;
        Pair(boolean isBst,long mini,long maxi){
            this.isBst = isBst;
            this.mini = mini;
            this.maxi = maxi;
        }
    }

    public Pair dfs(TreeNode node){
        if(node == null){
            return new Pair(true,Long.MAX_VALUE,Long.MIN_VALUE);
        }
        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        boolean isBst = left.isBst && right.isBst && node.val>left.maxi && node.val<right.mini;

        if(!isBst) return new Pair(false,-1,-1);
        long mini = Math.min(1L*node.val,left.mini);
        long maxi = Math.max(1L*node.val,right.maxi);
        return new Pair(isBst,mini,maxi);
    }

    public boolean isValidBST(TreeNode root) {
        
        Pair res = dfs(root);
        return res.isBst;
    }
}










