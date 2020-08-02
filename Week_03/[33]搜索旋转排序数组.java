//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 858 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：搜索旋转排序数组
    public class P33SearchInRotatedSortedArray{
        public static void main(String[] args) {
          Solution solution = new P33SearchInRotatedSortedArray().new Solution();
           // TO TEST
        }
            //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            //二分查找 ： 单调、边界、index
    public int search(int[] nums, int target) {
        //找到左右边界
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right)/2;
            //如果下标（0，mid）的数是升序的
            if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
                left = mid + 1;   //target要不在这个升序片段列的后方位置，要不在下一段升序片段列，都要将左指针向右移（向后规约）。
            //如果下标（0，mid）的数是旋转的
            else if(target < nums[0] && target > nums[mid])
                left = mid + 1;  //[5,1,3] 3比5小。但比1大。继续向后规约。
            else
                right = mid;
        }
        if(left == right && nums[left] == target) return left;
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}