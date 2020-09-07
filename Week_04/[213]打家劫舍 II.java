//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋
//装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。 
//
// 示例 1: 
//
// 输入: [2,3,2]
//输出: 3
//解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,1]
//输出: 4
//解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
// Related Topics 动态规划 
// 👍 346 👎 0


package leetcode.editor.cn;

//Java：打家劫舍 II
public class P213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new P213HouseRobberIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //dp[i][0] = max(dp[i-1][0],dp[i-1][1]);
        // dp[i][1] = dp[i-1] + nums[i];
        //    return max(偷第一个房子不透最后一个房子,不透第一个房子偷最后一个房子)
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.max(nums[0],nums[1]);
            return Math.max(helper(nums, 0, nums.length - 1),
                            helper(nums, 1, nums.length));
        }

        private int helper(int[] nums, int m, int n) {
            int[] dp = new int[nums.length];
            dp[m] = nums[m];
            dp[m+1]=Math.max(nums[m],nums[m+1]);
            int res = Math.max(dp[m],dp[m+1]);
            for(int i = m + 2; i < n; i++){
                dp[i] = Math.max(dp[i-1] , dp[i-2]+nums[i]);
                res = Math.max(res,dp[i]);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}