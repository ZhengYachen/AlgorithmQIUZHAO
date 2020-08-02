//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1179 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成
public class P22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res;
        public List<String> generateParenthesis(int n) {
            res = new ArrayList<>();
            generate(0, 0, n, "");
            return res;
        }

        private void generate(int left, int right, int max, String s) {

            if(left == max && right == max){
                res.add(s);
                return ;
            }
            if(left < max) generate(left+1, right, max, s+'(');
            if(right < left) generate(left, right+1, max, s+')');
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}