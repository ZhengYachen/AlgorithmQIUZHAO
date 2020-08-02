//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 459 👎 0


package leetcode.editor.cn;
    //Java：x 的平方根
    public class P69Sqrtx{
        public static void main(String[] args) {
          Solution solution = new P69Sqrtx().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        //leetcode测试数据加强了，所以为了防止越界，统一变成long
        long left = 0, right = x;
        if(x == 0 || x == 1) return x;
        while(left <= right){
            // 注意：这里把右界减少再除以2，代码会进入死循环
            long mid = left + (right - left)/2;
            if(mid * mid <= x){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return (int)right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}