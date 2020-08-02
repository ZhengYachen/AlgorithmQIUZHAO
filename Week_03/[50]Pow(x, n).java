//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 455 👎 0


package leetcode.editor.cn;

//Java：Pow(x, n)
public class P50PowxN {
    public static void main(String[] args) {
        Solution solution = new P50PowxN().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            long N = n;
            if (N >= 0) return helper(x, N);
            else return 1 / helper(x, -N);
        }

        private double helper(double x, long N) {
            if(N == 0) return 1.0;
            //分治
            double y = helper(x,N/2);
            //回溯(合并）
            //奇数，最后一个剩下的x要乘上
            if(N % 2 == 1) return y*y*x;
            //偶数
            else return y*y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}