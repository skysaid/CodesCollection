package Algorithm;

import java.util.*;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
public class a102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)return Collections.emptyList();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res=new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> inlist=new ArrayList<>();
            int n=queue.size();
            while (n>0){
                TreeNode temp=queue.poll();
                inlist.add(temp.val);
                if (temp.left!=null){
                    queue.addLast(temp.left);
                }
                if (temp.right!=null){
                    queue.addLast(temp.right);
                }
                n--;
                res.add(inlist);
            }
        }
        return res;
    }
}
