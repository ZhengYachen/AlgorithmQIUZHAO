//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 320 👎 0


package leetcode.editor.cn;
    //Java：二叉树的前序遍历
    public class P144BinaryTreePreorderTraversal{
        public static void main(String[] args) {
          Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root, List<Integer> res){
        if(root != null){
            res.add(root.val);
            if(root.left != null){
                helper(root.left,res);
            }
            if(root.right != null){
                helper(root.right,res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}