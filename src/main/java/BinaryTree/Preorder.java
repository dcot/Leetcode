package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode p = stack.pop();
            list.add(p.val);
            if (p.right!=null){
                stack.push(p.right);
            }
            if (p.left!=null){
                stack.push(p.left);
            }
        }
        return list;
    }
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(root,list);
        return list;
    }
    public void pre(TreeNode root,List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        pre(root.left,list);
        pre(root.right,list);
    }
}
