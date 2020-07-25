//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 49 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.Queue;

//Java：丑数
    public class P剑指 Offer 49ChouShuLcof{
        public static void main(String[] args) {
          Solution solution = new P剑指 Offer 49ChouShuLcof().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglynum = {2,3,5};
        //小顶堆 注意要用long类型，int会溢出
        Queue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        //记录堆的个数
        int count = 0;
        //加堆
        while(!queue.isEmpty()){
            long out = queue.poll();
            count++;
            //终止条件
            if(count >= n){
                return (int)out;
            }
            for(int num : uglynum){
                //很重要，去重
                if(!queue.contains(num*out))
                queue.add(num * out);
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}