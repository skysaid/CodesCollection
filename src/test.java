import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class test {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] prices,int m){
        if (prices==null||prices.length==0)return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(prices);
        dfs(prices,res,new ArrayList<>(),m,0);
        return res;
    }
    private void dfs(int[] prices,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int m,int index){
        if (m==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=index;i<prices.length&&m>=prices[i];i++){
            list.add(prices[i]);
            dfs(prices,res,list,m-prices[i],i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] prices=new int[]{1,4,3,5,7,8};
        test test=new test();
        ArrayList<ArrayList<Integer>> res=test.combinationSum(prices,8);
        for (ArrayList<Integer> list:res){
            StringBuilder sb=new StringBuilder();
            sb.append("[");
            for (int i:list){
                sb.append(i);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("]");
            System.out.println(sb.toString());
        }
    }
}
