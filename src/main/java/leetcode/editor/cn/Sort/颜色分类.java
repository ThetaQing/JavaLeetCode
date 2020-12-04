package main.java.leetcode.editor.cn.Sort;

/**
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。



 进阶：


 你可以不使用代码库中的排序函数来解决这道题吗？
 你能想出一个仅使用常数空间的一趟扫描算法吗？




 示例 1：


输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]


 示例 2：


输入：nums = [2,0,1]
输出：[0,1,2]


 示例 3：


输入：nums = [0]
输出：[0]


 示例 4：


输入：nums = [1]
输出：[1]




 提示：


 n == nums.length
 1 <= n <= 300
 nums[i] 为 0、1 或 2

 Related Topics 排序 数组 双指针
 👍 717 👎 0

 @author SongQing

 三向切分，就一个指针移动，两端只发生交换
 1、如果移动指针等于左端元素，交换移动指针和左指针，两个指针向前移一步（因为新交换过来的元素只有可能1，因为左边是已经遍历了，所有的0都已经移到左端了）
 2、如果移动指针等于右端元素，交换移动指针和右指针，右指针移动一步，移动指针不动，进行下一次判断，因为新交换过来的元素可能是0、1、2，右边的还没有开始遍历，
    所以都有可能，要进行下一次判断。
 3、如果移动指针等于中间元素，继续移动。

 有三种颜色的球，算法的目标是将这三种球按颜色顺序正确地排列。它其实是三向切分快速排序的一种变种，在三向切分快速排序中，
 每次切分都将数组分成三个区间：小于切分元素、等于切分元素、大于切分元素，而该算法是将数组分成三个区间：等于红色、等于白色、等于蓝色。
*/

public class 颜色分类{
    public static void main(String[] args){
        Solution solution = new 颜色分类().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        // 库函数排序
        // Arrays.sort(nums);
        // 三向切分
        int zero = -1, one = 0, two = nums.length;
        while(one < two){
            if(nums[one] == 0){
                swap(nums,++zero,one++);
            }else if(nums[one] == 2){
                swap(nums,--two,one);

            }else{
                one++;
            }
        }

    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
