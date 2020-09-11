package Algorithm;


import java.util.Arrays;
import java.util.LinkedList;

public class a297 {
    private String serializedfs(TreeNode root,String str){
        if (root==null){
            str+="null,";
        }else {
            str+=root.val+",";
            str=serializedfs(root.left,str);
            str=serializedfs(root.right,str);
        }
        return str;
    }
    private TreeNode deserializedfs(LinkedList<String> list){
        if (list.isEmpty())return null;
        if (list.getFirst().equals("null")){
            list.removeFirst();
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(list.removeFirst()));
        root.left=deserializedfs(list);
        root.right=deserializedfs(list);
        return root;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializedfs(root,"");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list= new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializedfs(list);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right=new TreeNode(5);
        a297 a=new a297();
        String str=a.serialize(root);
        a.deserialize(str);
    }
}
