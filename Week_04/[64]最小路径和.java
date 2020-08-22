//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 638 👎 0


package leetcode.editor.cn;
    //Java：最小路径和
    public class P64MinimumPathSum{
        public static void main(String[] args) {
          Solution solution = new P64MinimumPathSum().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //考虑边界条件
                if(i == 0 && j ==0) continue;
                else if(i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(j == 0) dp[i][j] = dp[i-1][j] +grid[i][j];
                else dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];

            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}