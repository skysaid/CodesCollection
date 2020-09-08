package Algorithm;
//给定一个二叉树，它的每个结点都存放着一个整数值。
//        找出路径和等于给定数值的路径总数。
//        路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//        二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

import java.util.HashMap;

public class a437 {
    public int pathSum(TreeNode root, int sum) {
        return dfs(root,sum,0,new HashMap<Integer,Integer>(){{put(0,1);}});
    }
    private int dfs(TreeNode root, int sum, int pathum, HashMap<Integer,Integer> map){
        if (root==null)return 0;
        int res=0;
        pathum+=root.val;
        res+=map.getOrDefault(pathum-sum,0);
        map.put(pathum,map.getOrDefault(pathum,0)+1);
        res+=dfs(root.left,sum,pathum,map)+dfs(root.right,sum,pathum,map);
        map.put(pathum,map.get(pathum)-1);
        return res;
    }
}
