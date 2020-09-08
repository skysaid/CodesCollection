package Algorithm;
//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
//注意：你不能在买入股票前卖出股票。

public class a121 {
    public int maxProfit(int[] prices) {
        if (prices.length==0)return 0;
        int cur_min=prices[0];
        int max_earning=0;
        for (int price : prices){
            if (price<cur_min)cur_min=price;
            if (price-cur_min>max_earning)max_earning=price-cur_min;
//            cur_min=Math.min(cur_min,price);
//            max_earning=Math.max(max_earning,price-cur_min);
        }
        return max_earning;
    }
}
