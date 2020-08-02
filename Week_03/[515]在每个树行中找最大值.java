//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 81 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：在每个树行中找最大值
    public class P515FindLargestValueInEachTreeRow{
        public static void main(String[] args) {
          Solution solution = new P515FindLargestValueInEachTreeRow().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);
                //注意下面是node节点的左右子树，不是root（细心）
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}