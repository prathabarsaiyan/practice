package main.pratha;

// Validate BST
//
// Implment a function to check if a binary tree is a binary search tree
//
//      10
//    /    \
//   5     16
//  / \      \
// 2   12     19

//	10, null, null
// 	(5, null, 10)  						:  (16,10,null)
//	(2, null, 5): (7, 5, 10) 			:: (null, 10, 16) (19, 16, null)
//


public class CheckBST {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(5, new TreeNode(2), new TreeNode(7));
        TreeNode right = new TreeNode(16, null, new TreeNode(19));
        TreeNode root = new TreeNode(10, left,  right);

        System.out.println(checkBST(root, null, null));
    }

    public static boolean checkBST(TreeNode node, TreeNode left, TreeNode right) {
        if (node == null){
            return true;
        }

        if(left != null && node.data < left.data){
            return false;
        }

        if(right != null && node.data > right.data){
            return false;
        }

        return checkBST(node.left, left , node) && checkBST(node.right, node, right);
    }

    public static class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}

