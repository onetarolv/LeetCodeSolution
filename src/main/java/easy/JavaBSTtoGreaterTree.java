package easy;

import util.JavaTreeNode;

import java.util.Stack;

/**
 * Created by engry on 2017/9/21.
 * 538 Convert BST to Greater Tree??
 */
public class JavaBSTtoGreaterTree {
    public JavaTreeNode convertBST(JavaTreeNode root) {
        if (root == null)
            return null;
        if (root.right == null && root.left == null) {
            return root;
        }

        if (root.right != null) {
            if (root.right.right != null) {
                root.right.right = convertBST(root.right.right);
                root.right.val += root.right.right.val;
            }
            if (root.right.left != null) {
                root.right.left = convertBST(root.right.left);
                root.right.val += root.right.left.val;
            }
            root.val += root.right.val;
        }
        if (root.left != null) {
            root.left = convertBST(root.left);
            root.left.val = root.left.val + root.val;
        } else {
        }
        return root;
    }

    public JavaTreeNode convertBST_1(JavaTreeNode root) {
        if(root == null)
            return null;
        if(root.right == null && root.left == null){
            return root;
        }
        Stack stack = new Stack<JavaTreeNode>();
        int count = 0;
        JavaTreeNode tn = root;
        while((!stack.isEmpty()) || tn != null){
            while(tn !=null){
                stack.push(tn);
                tn = tn.right;
            }
            if(!stack.isEmpty()){
                tn = (JavaTreeNode) stack.pop();
                count += tn.val;
                tn.val = count;
                tn = tn.left;

            }
        }
        return root;
    }
}
