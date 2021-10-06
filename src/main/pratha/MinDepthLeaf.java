package main.pratha;

import java.util.*;

/*
Given a tree data structure, find the leaf with minimum depth.

The depth of the node is the number of nodes along the shortest path from the root node down to it.
Note: A leaf is a node with no children.

Example
Input:
           7
          / \
        6     5
       / \
      4  3
Output: 5

*/

public class MinDepthLeaf {

    static TreeNode getLeafWithMinDepth(TreeNode root){
        if(root == null){
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = root;
        q.add(node);

        while(!q.isEmpty()){
            node = q.poll();
            if(node.left == null && node.right == null){
                return node;
            }
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        return node;
    }

    public static void main(String args[] ) throws Exception {
        TreeNode L2_1 = new TreeNode(4);
        TreeNode L2_2 = new TreeNode(3);

        TreeNode L1_1 = new TreeNode(6,L2_1, L2_2);
        TreeNode L1_2 = new TreeNode(5);

        TreeNode root = new TreeNode(1, L1_1, L1_2);

        System.out.println(getLeafWithMinDepth(root));

    }
}