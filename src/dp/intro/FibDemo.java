package dp.intro;

import java.util.HashMap;

public class FibDemo {
    //传统写法
    public static int fib(int n){
        if (n==1 || n==2) return 1;
        return fib(n-1)+fib(n-2);
    }

    //添加备忘录
    private static HashMap<Integer,Integer> map = new HashMap<>();
    public static int fib1(int n){
        if (n==1 || n==2) return 1;
        if (map.containsKey(n))return map.get(n);
        int result = fib(n-1)+fib(n-2);
        map.put(n,result);
        return fib(n-1)+fib(n-2);
    }

    //dp
    public static int fib2(int n){
        int [] dp = new int [n+1];
        dp[1] = 1;dp[2]=1;
        for (int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    public static int fib3(int n){
        if (n==1||n==2) return 1;
        int prev=1,curr =1;
        for (int i=3;i<=n;i++){
            //达到一个更换的效果
            int sum = prev+curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
    public static void main(String[] args) {
        System.out.println(fib3(3));
    }
}
