package 笔试题;

public class 自然数因数分解最小和 {
    public static int minSum(int n){
        if(1 == n || 2 == n) return n;
        for(int i = 2; i <= n/2; i++) //n若有因子肯定小于等于n/2
        {
            if(n % i == 0) //i为n的一个因子
            {
                if(minSum(i) == i) //若最小和等于本身则表示i为素数
                {
                    return i + minSum(n / i);
                }
            }
        }
        return n; //素数，返回本身
    }
    public static void main(String[] args){
        System.out.println(minSum(6));
    }
}
