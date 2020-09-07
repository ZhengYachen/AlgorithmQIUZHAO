//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 219 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：有效的字母异位词
    public class P242ValidAnagram{
        public static void main(String[] args) {
          Solution solution = new P242ValidAnagram().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
//        //用数组实现哈希映射原理
//        if(s.length() != t.length()) return false;
//        int[] hash = new int[26];
//        for(int i = 0; i < s.length(); i++) {
//            hash[s.charAt(i) - 'a']++;
//            hash[t.charAt(i) - 'a']--;
//        }
//        for(int i = 0; i < 26; i++){
//            if(hash[i] != 0) return false;
//        }
//        return true;

        //char数字排序
        char[] a1 = s.toCharArray();
        char[] a2 = t.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}