package Algorithm;

public class a42 {
    public int trap(int[] height) {
        if (height==null||height.length==0)return 0;
        int len=height.length;
        int[] left=new int[len];
        int[] right=new int[len];
        left[0]=height[0];
        right[len-1]=height[len-1];
        for (int i=1;i<len;i++){
            left[i]=Math.max(left[i-1],height[i]);
            right[len-1-i]=Math.max(right[len-i],height[len-i-1]);
        }
        int ans=0;
        for (int i=0;i<len;i++){
            ans+=Math.min(left[i],right[i])-height[i];
        }
        return ans;
    }
}
