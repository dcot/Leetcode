package interview;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> list = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        /*
        DFS
        255 255 111 35
        从第一个字符2的开始后面加点分割，至多分割出三位
        cnt表示剩余的“.”的个数，n个点能将字符串分割为n+1组，如果s.length() > (cnt+1)*3，那么无论怎么分割，都会造成大于三位数一组的情况 如2555
        如果分割时发现数字大于255，返回
        如果以0为开头，必然只能分割一位
         */
        return new ArrayList<>();
    }
    public void dfs(String s, int cnt, String res) {
        if (s.length() > (cnt+1)*3) return;
        int num = Integer.parseInt(s.substring(0,3));
        if (num > 255) return;
        if (cnt == 0) {
            res+=s;
            list.add(new String(res));
        }
        for (int i = 1; i < res.length() && i < 3; i++) {
            res += s.substring(0,i);
            res+=".";
            dfs(s.substring(i,s.length()),cnt--,res);
        }
    }
}
