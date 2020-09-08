package Algorithm;

public class a461 {
    //两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
    //给出两个整数 x 和 y，计算它们之间的汉明距离。
    public static int hammingDistance(int x, int y) {
        int c=x^y;
        int top=c/2+1;
        int i=1;
        int ans=0;
        while(c!=0){
            if (c%2==1)ans++;
            c/=2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(9,8));
    }
}
