package Algorithm;

import java.util.Deque;
import java.util.LinkedList;

//        给定一个二叉树，找出其最大深度。
//        二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
public class a104 {
    public int maxDepth(TreeNode root) {


//        if (root==null)return 0;
//        int left=maxDepth(root.left);
//        int right=maxDepth(root.right);
//        return left>right?left+1:right+1;

        if (root==null)return 0;
        Deque<TreeNode> que=new LinkedList<>();
        que.addFirst(root);
        int ans=0;
        while (!que.isEmpty()){
            ans++;
            int size=que.size();
            for (int i=0;i<size;i++){
                TreeNode cur=que.poll();
                if (cur.left!=null)que.addLast(cur.left);
                if (cur.right!=null)que.addLast(cur.right);
            }
        }
        return ans;
    }
}
