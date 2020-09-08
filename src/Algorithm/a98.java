package Algorithm;

import java.util.ArrayList;

public class a98 {
    public boolean isValidBST(TreeNode root) {
        if (root==null)return true;
        ArrayList<Integer> list=new ArrayList<>();
        dfs(root,list);
        for (int i=0;i<list.size()-1;i++){
            if (list.get(i)>list.get(i+1))return false;
        }
        return true;
    }
    public void dfs(TreeNode root, ArrayList<Integer> list){
        if (root==null)return;
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
