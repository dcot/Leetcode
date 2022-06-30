package interview;

import com.sun.source.tree.SynchronizedTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SplitAverage {

    class ValueIllegalException extends Exception {
        public ValueIllegalException() {
        }

        public ValueIllegalException(String message) {
            super(message);
        }
    }
    /*
    假设先只考虑int类型取值范围
    （如果可能超过int范围，接口的n,x设置为字符串，随后判断字符串是否超过范围，超过的话用BigInteger，重载即可）
    先把每份向下取整取值为n/x，设n/x = quotient，n%x = remainder
    1、如果n/x可以整除，，则直接分配大小为x的数组，元素值都为n/x;
    2、如果不能整除，为前remainder个数，每个+1
     */
    public synchronized int[] IntegerSplit(int n, int x) {
        int[] nums = null;
        try {
            if (!isValid(n, x)) {
                throw new ValueIllegalException("Illegal value n:" + n + ",x:" + x);
            } else {
                int remainder = n % x;
                int quotient = n / x;
                nums = new int[x];
                if (remainder == 0) {
                    Arrays.fill(nums, quotient);
                } else {
                    for (int i = 0; i < x; i++) {
                        nums[i] = i < remainder ? quotient + 1 : quotient;
                    }
                }
            }
        } catch (ValueIllegalException v) {
            v.printStackTrace();
        } finally {
            return nums;
        }
    }
    /*
    输入要符合要求：
    (x<=n)保证每份均为整数
    (n>0) 保证 >= n/2x，并且 <= 2n/x
     */
    public boolean isValid(int n, int x) {
        if (n > 0 && x <= n && x > 0) return true;
        else return false;
    }
}
