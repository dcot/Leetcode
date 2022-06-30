package interview;
import java.util.*;
public class CountLetters {
    /*
    9122
    先取出后两位，判断是否大于20
    大于20，就是十位+个位
    小于20，一个单词one-twenty
    等于0，跳过
    再取百位，存在就是x-hundred，等于0就跳过
    再取千位，存在就是x-thousand，等于0跳过
     */
    //存0 <20、（30、40...）、（100、200...）这些情况下key对应的letter counts
    public Map<Integer,Integer> map = new HashMap<>();
    public int count(int num){
        //个位到千位
        int digit1 = num % 10;
        int digit2 = num % 100 - digit1;
        int digit3 = num % 1000 - digit1 - digit2;
        int digit4 = num % 1000;
        int cnt = 0;
        if (digit1 + digit2*10 <= 20) {
            cnt += map.get(digit1 + digit2*10);
        }
        else {
            cnt += map.get(digit1);
            cnt += map.get(digit2*10);
        }

        if (digit3 != 0) {
            //hundred长度为7 xx hundred
            cnt += map.get(digit3)+7;
        }

        if (digit4 != 0) {
            //thousand长度为8 xx hundred
            cnt += map.get(digit4)+8;
        }
        return cnt;
    }
}
