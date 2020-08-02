//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 817 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列
public class P46Permutations {
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            if(nums == null) return res;

            helper(nums,new ArrayList<>());
            return res;
        }

        private void helper(int[] nums, ArrayList<Integer> track) {
            if(track.size() ==  nums.length){
                res.add(new ArrayList<>(track));
                return;
            }
            for (int num : nums) {
                // 排除不合法的选择
                if (track.contains(num))
                    continue;
                //做选择
                track.add(num);
                helper(nums, track);    //与组合（77）那道题不同，它的递归是从零开始遍历，因为可重复，走过的还能走。
                //撤销选择
                track.remove(track.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}