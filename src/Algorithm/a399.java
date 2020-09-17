package Algorithm;

import java.util.*;

public class a399 {
    HashMap<String,String> parent;
    HashMap<String,Double> parentValues;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res=new double[queries.size()];
        parent=new HashMap<>();
        parentValues=new HashMap<>();


        for (int i=0;i<equations.size();i++){
            List<String> list=equations.get(i);
            String left=list.get(0);
            String right=list.get(1);
            union(left,right,values[i]);
        }
        for (int i=0;i<queries.size();i++){
            List<String> list=queries.get(i);
            if (!parent.containsKey(list.get(0))||!parent.containsKey(list.get(1))){
                res[i]=-1;
                continue;
            }
            String left=list.get(0);
            String right=list.get(1);
            String pL=findParent(left);
            String pR=findParent(right);
            if (!pL.equals(pR)){
                res[i]=-1.0;
            }
            else {
                res[i]=parentValues.get(right)/parentValues.get(left);
            }
        }
        return res;
    }

    public String findParent(String index){
        String i=index;
        double value=1;
        while (!parent.getOrDefault(i,i).equals(i)){
            value*=parentValues.get(i);
            i=parent.get(i);
        }
        parentValues.put(index,value);
        parent.put(index,i);
        return i;
    }

    public void union(String left,String right,double value){
        String pL=findParent(left);
        String pR=findParent(right);
        if (!pL.equals(pR)){
            parentValues.put(pR,value*parentValues.get(left)/parentValues.get(right));
            parent.put(pR,pL);
        }
    }
}
