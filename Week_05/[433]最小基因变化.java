//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 44 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//Java：最小基因变化
    public class P433MinimumGeneticMutation{
        public static void main(String[] args) {
          Solution solution = new P433MinimumGeneticMutation().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            //1 把begin放入队列中
            //2 出队一个元素，修改这个元素上第一字母，修改值在这四个字母中选择'A', 'C', 'G', 'T'，四个字母都遍历一遍，
                // 如果和最后一个元素匹配，那么就退出，返回当前的层级（step）
                // 如果修改后的元素在bank的中出现，那么就放入队列中，同时删除bank中的相同的元素。
            //3 然后把第一个元素还原原先的字母，然后开始修改第二个字母。执行和第2步一致。

    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank)); //返回由指定数组支持的固定大小的列表。
        if(!set.contains(end)){
            return -1;
        }
        char[] four = {'A','C','G','T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start); //如果bank里有这个元素，则移除它。
        int step = 0;
        while(queue.size() > 0){
            step++;
            for(int count = queue.size(); count > 0; --count){
                char[] temp = queue.poll().toCharArray();
                for(int i = 0; i < temp.length; i++){
                    char oldChar = temp[i];
                    for(int j = 0; j < 4; j++){
                        temp[i] = four[j];
                        String newString = new String(temp);
                        if(end.equals(newString)) return step;
                        else if(set.contains(newString)){
                            set.remove(newString);
                            queue.offer(newString);
                        }
                    }
                    temp[i] = oldChar;
                }
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}