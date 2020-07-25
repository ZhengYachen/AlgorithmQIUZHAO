//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索 
// 👍 98 👎 0


package leetcode.editor.cn;
    //Java：N叉树的层序遍历
    public class P429NAryTreeLevelOrderTraversal{
        public static void main(String[] args) {
          Solution solution = new P429NAryTreeLevelOrderTraversal().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(root, 0, res);
        return res;
    }
    public void helper(Node root,int deep, List<List<Integer>> res){
        if(deep + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(deep).add(root.val);
        //处理子节点
        for (Node node : root.children) {
            if (node != null) {
                helper(node, deep + 1, res);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}