package Algorithm;
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
public class a338 {
    public int[] countBits(int num) {
        int[] ans =new int[num+1];
        int b2=0;
        int index=0;
        while (index<=num){
            for (int i=0;i<b2&&i+index<=num;i++){
                ans[index+i]=ans[i]+1;
            }
            index+=b2;
            b2=b2<<1;
        }
        return ans;
    }
}
