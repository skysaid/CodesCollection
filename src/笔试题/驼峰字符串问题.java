package 笔试题;

public class 驼峰字符串问题 {
    private static String solve(String input) {
        String res = "";
        for (int i = 0; i < input.length(); i++) {
            char pre = input.charAt(i);
            boolean mark=true;
            for (int j = i+2; j < input.length(); j=j+2) {
                char next = input.charAt(j);
                char mid = input.charAt(j-1);
//                if(pre==next&&pre!=mid) {
//                    i=j;
//                    mark=false;
//                }else break;
                if(pre==next&&pre!=mid) {
                    i=j;
                    mark=false;
                    break;
                }
            }
            //没有发现驼峰则把当前字符串加入
            if(mark) {
                res+=pre;
            }
        }
        //检查清除驼峰后的字符串是否还存在驼峰
        if(input.length()==res.length())
            return res;
        else return solve(res);
    }

    public static void main(String[] args) {
        String str="abaacbcdaf";
        System.out.println(solve(str));
    }
}
