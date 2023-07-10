import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

	public static class Pair{
		TreeNode node;
		int state;
		Pair(TreeNode node,int state){
			this.node  = node;
			this.state  = state;
		}
	}

	public static TreeNode getNextInorder(Stack<Pair> st){
		while(st.size()>0){
			Pair top = st.peek();
			if(top.state == 1){
				//pre
				top.state++;
				if(top.node.left != null) st.push(new Pair(top.node.left,1));
			}else if(top.state == 2){
				//in
				top.state++;
				if(top.node.right != null) st.push(new Pair(top.node.right,1));
				return top.node;
			}else if(top.state == 3){
				st.pop();
			}
		}
		return null;
	}
	
	
    public static void recoverTree(TreeNode root) {
        //Write code here

		Stack<Pair> st  = new  Stack<>();
		st.push(new Pair(root,1));
		
		TreeNode a =null;
		TreeNode  b  = null;
		
		TreeNode curr = getNextInorder(st);
		TreeNode prev = curr;
		curr = getNextInorder(st);

		while(curr != null){
			if(curr.val < prev.val){
				//it is unsorted pair
				if(a == null){
					//first unsorted pair
					a = prev;
					b = curr;
				}else{
					//second unsorted pair
					b = curr;
				}
			}

			prev = curr;
			curr = getNextInorder(st);
		}
		//swapping bad node values
		int  temp = a.val;
		a.val = b.val;
		b.val = temp;

    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}