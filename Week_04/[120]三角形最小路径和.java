//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 561 👎 0


package leetcode.editor.cn;

import java.util.List;

//Java：三角形最小路径和
    public class P120Triangle{
        public static void main(String[] args) {
          Solution solution = new P120Triangle().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //1. 重复性（分治） problem(i,j) = min(sub(i+1,j),sub(i+1,j+1)+a[i,j]
        //2. 定义状态数组：f[i,j]
        //3. DP方程： f[i,j] = min(f[i+1,j], f[i+1,j+1] + triangle[i,j]
        //又因为两个比较大小的都是同一行i+j，所以f[i+j]只需要以为数组f[j]即可。
        int[] dp = new int[triangle.size()+1];
        for(int i = triangle.size()-1; i >=0 ; i--){
            for(int j = 0; j < triangle.get(i).size();j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}