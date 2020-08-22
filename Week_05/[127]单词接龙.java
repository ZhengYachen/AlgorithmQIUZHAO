//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 395 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：单词接龙
    public class P127WordLadder{
        public static void main(String[] args) {
          Solution solution = new P127WordLadder().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || ! wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);//取出来放入队列
        //图的优先遍历，队列+visited（数组 or hash表）
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int wordLen = beginWord.length();
        // 包含起点，因此初始化的时候步数为 1
        int step = 1;

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++){
                String word = queue.poll();
                char[] charArray = word.toCharArray();

                //修改每个字符
                for(int j =0; j < wordLen; j++){
                    // 一轮以后应该重置，否则结果不正确
                    char originchar = charArray[j];
                    for(char k = 'a'; k <= 'z'; k++){
                        if(k == originchar) continue;
                        charArray[j] = k;
                        String nextword = String.valueOf(charArray);
                        if(wordSet.contains(nextword)){
                            if(nextword.equals(endWord)) return step + 1;
                            if (!visited.contains(nextword)) {
                                queue.add(nextword);
                                // 注意：添加到队列以后，必须马上标记为已经访问
                                visited.add(nextword);
                            }
                        }

                    }
                //reverse
                    charArray[j] = originchar;
                }
            }
            step++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}