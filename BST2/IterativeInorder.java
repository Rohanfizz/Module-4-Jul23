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
        TreeNode node;
        int state;
        Pair(TreeNode node,int state){
            this.node = node;
            this.state = state;
        }
    }

    public TreeNode getNextInorder(Stack<Pair>st){
        while(st.size()>0){
            Pair top = st.peek();
            if(top.state == 1){
                //pre work
                top.state++;
                if(top.node.left != null) st.push(new Pair(top.node.left,1));
            }else if(top.state == 2){
                //in
                top.state++;
                if(top.node.right != null) st.push(new Pair(top.node.right,1));
                return top.node;
            }else{
                //post
                st.pop();
            }
        }
        return null;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if(root== null) return inorder;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        TreeNode curr = getNextInorder(st);

        while(curr!=null){
            inorder.add(curr.val);
            curr = getNextInorder(st);
        }

        return inorder;

    }
}











