//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步
//，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 481 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Java：N皇后
public class P51NQueens {
    public static void main(String[] args) {
        Solution solution = new P51NQueens().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            if(n == 0 ){
                return result;
            }
            List<String> path = new ArrayList<>(); //指一种解法
            boolean[] col = new boolean[n];
            boolean[] pie = new boolean[2*n-1];
            boolean[] na = new boolean[2*n-1];
            dfs(n,path,col,pie,na,result);
            return result;
        }

        private void dfs(int n, List<String> path, boolean[] col, boolean[] pie, boolean[] na, List<List<String>> result) {
            if(path.size() == n){//遍历到最后一行
                result.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < n; i++){//一行一行遍历
                if(col[i]) continue;//是否同一列有皇后
                int pieline = i + path.size();  //必须这样定义出来，不能把i+path.size直接作为下标，因为add了之后path.size加1了
                if(pie[pieline]) continue; //i相当于x，path.size()相当于y
                int naline = n-1-i + path.size();
                if(na[naline]) continue;
                //添加记录
                path.add(getLines(n,i));
                col[i] = true;
                pie[pieline] = true;
                na[naline] = true;
               // drill down
                dfs(n,path,col,pie,na,result);
                //reverse state
                path.remove(path.size()-1);
                col[i] = false;
                pie[pieline] = false;
                na[naline] = false;
            }
        }
        private String getLines(int n, int column){
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < n; i++){
                result.append(i == column ? "Q" : ".");
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}