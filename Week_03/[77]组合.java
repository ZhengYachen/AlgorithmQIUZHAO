//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例:
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// Related Topics 回溯算法
// 👍 321 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//Java：组合
public class P77Combinations {
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        //典型的回溯算法，k 限制了树的高度，n 限制了树的宽度
        public List<List<Integer>> combine(int n, int k) {
            if (n <= 0 || k <= 0) return res;
            helper(1,n, k, new LinkedList<Integer>());
            return res;
        }

        private void helper(int level, int n, int k, LinkedList<Integer> track) {
            //到达数的底部
            if(track.size() == k){
                //path 这个变量所指向的对象在递归的过程中只有一份，深度优先遍历完成以后，回到了根结点
                //因为我们之前说了，从深层结点回到浅层结点的时候，需要撤销之前的选择），因此 path 这个变量回到根结点以后都为空。
                //解决的方法很简单，在 res.add(track); 这里做一次拷贝即可。
                res.add(new LinkedList<>(track));   //拷贝一份track。
                return;
            }
            for(int i = level; i <= n; i++){
                //做选择
                track.add(i);
                helper(i+1, n, k, track);
                //撤销选择
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}