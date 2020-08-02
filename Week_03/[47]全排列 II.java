//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 364 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null) return res;
            Arrays.sort(nums);    //排序是剪枝的前提

            boolean[] used = new boolean[nums.length];  //额外空间去重剪枝

            helper(0,nums, new ArrayList<>(),used);
            return res;
        }

        private void helper(int level,int[] nums, ArrayList<Integer> track,boolean[] used) {
            if (level == nums.length) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i= 0; i < nums.length; i++) {
                // 剪枝
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                    continue;
                }
                //做选择
                track.add(nums[i]);
                used[i] = true;
                helper(level+1, nums, track, used);
                //撤销选择 回溯
                used[i] = false;
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}