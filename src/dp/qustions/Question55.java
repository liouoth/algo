package dp.qustions;

import java.util.Arrays;

public class Question55 {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     *
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
     *
     * 示例 2:
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */

    /**
     * 暴力解,会超出时间限制
     */
    public static boolean jump(int [] array,int position){
        if (position==array.length-1){
            return true;
        }
        int i;
        for (i = 1;i+position<array.length&&i<=array[position];i++){
            if (!jump(array,position+i)){
                continue;
            }
            return true;
        }
        return false;
    }

    //动态规划
    //dp[i]就是状态
    //dp[i+step],如果i+step>=array.length-1，则为true
    public static boolean jump2(int [] nums){
        boolean [] dp = new boolean [nums.length];
        Arrays.fill(dp,false);
        dp[nums.length-1] = true;
        for (int i = nums.length-2;i<nums.length&&i>=0;i--){
            for (int j = 1;j<=nums[i];j++){
                if (i+j>=nums.length-1?true:dp[i+j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    //优化
    public static boolean jump3(int [] nums){
        int [] dp = new int [nums.length];
        Arrays.fill(dp,0);
        dp[nums.length-1] = 1;
        int near_index=nums.length-1;
        for (int i = nums.length-2;i>=0;i--){
            if (i+nums[i]>=near_index) {
                dp[i] = 1;
                near_index = i;
            }
        }
        return dp[0]==1;
    }

    //优化,只保留一个状态
    public static boolean jump4(int [] nums){
        if (nums==null||nums.length==0){
            return true;
        }
        int near_index=nums.length-1;//最近一个为true的数组下标
        for (int i = nums.length-2;i>=0;i--){
            if (i+nums[i]>=near_index) {
                near_index = i;
            }
        }
        return nums[0]>=near_index;
    }

    public static void main(String[] args) {
        System.out.println(jump4(new int[]{1,0,0}));
    }
}
