package Algorithm;
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

public class a11 {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int res=Math.min(height[left],height[right])*(right-left);
        while (left<right){
            if (height[left]>height[right]){
                while (left<right&&height[right]>height[right-1])right--;
                right--;
            }else {
                while (left<right&&height[left]>height[left+1])left++;
                left++;
            }
            res=Math.max(res,Math.min(height[left],height[right])*(right-left));
        }
        return res;
    }
}
