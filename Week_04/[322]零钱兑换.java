//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划 
// 👍 746 👎 0


package leetcode.editor.cn;

//Java：零钱兑换
public class P322CoinChange {
    public static void main(String[] args) {
        Solution solution = new P322CoinChange().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//1.baoli:递归
// 2.BFS
//3.DP
        //   a.subproblem
        //   b.DP Array: f(n) = min({f(n-k),for k in[1,2,5]}+1)

        //递归：
        //int res = Integer.MAX_VALUE;
//        int memo[] ;
//        public int coinChange(int[] coins, int amount) {
//            if (coins.length == 0) return -1;
//            memo = new int[amount];
//            return helper(coins, amount, 0);
//
//        }
//
//        private int helper(int[] coins, int amount, int level) {
//            if(amount < 0) return -1;
//            if(amount == 0) return 0;
//            //记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
//            // 直接的返回memo[n] 的最优值
//            if(memo[amount -1] != 0) return memo[amount-1];
//            int min = Integer.MAX_VALUE;
//            for(int i =0; i < coins.length; i++){
//
//                int res = helper(coins,amount-coins[i],level + 1);
//                if(res >= 0 && res < min) {
//                    min = res + 1;
//                }
//            }
//            memo[amount-1] = (min == Integer.MAX_VALUE? -1:min);
//            return memo[amount-1];
//        }
// 动态规划
        public int coinChange(int[] coins, int amount) {
           if(coins.length == 0) return -1;
           int[] dp = new int[amount+1];
           dp[0] = 0;  //因为dp设置了size+1的大小，循环从1开始，所以dp[0]需要单独定义
           for(int i = 1; i <= amount; i++){
               int min = Integer.MAX_VALUE;
               for(int j = 0; j < coins.length; j++){
                   if(i-coins[j] >= 0 && dp[i-coins[j]] < min )
                       min = dp[i-coins[j]] + 1;
               }
               dp[i] = min;
           }
           return (dp[amount] == Integer.MAX_VALUE? -1:dp[amount]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}