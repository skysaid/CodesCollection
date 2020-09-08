package Algorithm;
//给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//找到所有在 [1, n] 范围之间没有出现在数组中的数字。

import java.util.ArrayList;
import java.util.List;

public class a448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        int n = nums.length;
//        int[] map = new int[n+1];
//        for (int num : nums){
//            map[num]++;
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 1; i < n+1; i++){
//            if (map[i]==0)list.add(i);
//        }
//        return list;

        int n = nums.length;
        for (int num: nums){
            int num_abs = Math.abs(num);
            if (nums[num_abs-1]>0)nums[num_abs-1]*=-1;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n ; i++){
            if (nums[i]>0)res.add(i+1);
        }
        return res;
    }
}
