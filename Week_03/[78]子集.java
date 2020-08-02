//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics 位运算 数组 回溯算法 
// 👍 677 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：子集
public class P78Subsets {
    public static void main(String[] args) {
        Solution solution = new P78Subsets().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null) return res;
            List<Integer> list = new ArrayList<>();
            dfs(res, nums, list, 0);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
            //list = new ArrayList<>();
            //terminator
            if(index == nums.length) {
                res.add(new ArrayList<>(list));  //存储方式是将list放到一个新实例对象中
                return;
            }
            //不选当前index所指的这个数
            dfs(res,nums,list,index+1);
            //选当前这个数,list存储中间结果
            list.add(nums[index]);
            dfs(res,nums,list,index+1);
            //reverse current state
            //把最后加进去的数去掉
            list.remove(list.size()-1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}