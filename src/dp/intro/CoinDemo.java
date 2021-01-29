package dp.intro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinDemo {
    /**
     * 给你 k 种⾯值的硬币，⾯值分别为 c1, c2 ... ck ，每种硬
     * 币的数量⽆限，再给⼀个总⾦额 amount ，问你最少需要⼏枚硬币凑出这个
     * ⾦额，如果不可能凑出，算法返回 -1
     *
     * 想法先从自顶向下，再从自底向上
     */

    //暴力递归，硬币无限，每次从数组中选择
    //每层如果成功则返回+1，这样就不用携带参数
    static int coin(int [] coins,int amount){
        if (amount==0){
            return 0;
        }else if (amount<0){
            return -1;
        }
        int max_value = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coin(coins,amount-coin);
            if (result==-1)continue;
            max_value=max_value>result?result+1:max_value;
        }
        return max_value==Integer.MAX_VALUE?-1:max_value;
    }

    //添加备忘录

    private static Map<Integer,Integer> map = new HashMap<>();

    static int coin1(int [] coins, int amount){
        if (map.containsKey(amount))return map.get(amount);
        if (amount==0){
            return 0;
        }else if (amount<0){
            return -1;
        }
        int max_value = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coin1(coins,amount-coin);
            if (result==-1)continue;
            max_value=max_value>result?result+1:max_value;
        }
        map.put(amount,max_value==Integer.MAX_VALUE?-1:max_value);
        return map.get(amount);
    }

    //分析状态就是amount，当amount满足时就返回
    //dp[i]=x,当目标金额为i时，最少需要i枚金币
    //dp[i+coin]=dp[i]+1
    static int coin2(int [] coins, int amount){
        int [] dp = new int [amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i =0;i<dp.length;i++){
            for (int coin:coins){
//                if (i+coin>amount)continue;
//                dp[i+coin] = dp[i+coin]>dp[i]+1?dp[i]+1:dp[i+coin];
                if (i-coin<0)continue;
                dp[i] = dp[i]>dp[i-coin]+1?dp[i-coin]+1:dp[i];
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        System.out.println(coin2(new int [] {1, 5, 2}, 100));
    }
}
