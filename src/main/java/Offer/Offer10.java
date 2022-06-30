package Offer;

public class Offer10 {
//    dp[i]=dp[i-1]+dp[i-2]
//    dp[1]=1 dp[2]=2 dp[3]=1+1+1=1+2=2+1=3=dp[1]+dp[2]
    public int numWays(int n) {
        int res = 0;
        int[] dp = new int[101];
        final int mod = 1000000007;
        dp[0]=dp[1]=1;
        dp[2]=2;

        if (n==0||n==1) return dp[0];
        else if(n==2) return dp[2];

        for (int i = 3; i <= n; i++) {
            dp[i]=(dp[i-1]%mod+dp[i-2]%mod)%mod;
        }
        return dp[n];
    }
    public int fib(int n) {
        final int mod = 1000000007;
        int a = 0;//dp[0]
        int b = 1;//dp[1]
        int sum = a+b;
        if (n == 0) return a;
        if (n == 1) return b;
        for (int i = 2;i <= n;i++){
            sum = (a%mod + b%mod)%mod;
            a = b;//dp[0]->dp[1]
            b = sum;//dp[1]->dp[2]
        }
        return sum;
    }
}
