package main.java.leetcode.editor.cn.Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

 示例 1:

 输入: [3,2,1,5,6,4] 和 k = 2
输出: 5


 示例 2:

 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

 说明:

 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 Related Topics 堆 分治算法
 👍 795 👎 0
*/
public class 数组中的第K个最大元素{
    public static void main(String[] args){
        Solution solution = new 数组中的第K个最大元素().new Solution();
        int[] ints = {3,2,3,1,2,4,5,5,6};
        System.out.println(solution.findKthLargest(ints, 4));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int findKthLargest(int[] nums, int k){  // 快排
        k = nums.length - k;
        int l = 0,h = nums.length-1;
        while (l < h){
            int j = partition(nums,l,h);
            if(j == k){
                break;
            }else if(j < k){
                l = j + 1;
            }else{
                h = j - 1;
            }

        }
        return nums[k];


    }
    private int partition(int[] array, int l, int h){
        int i  = l,j = h+1;
        while (true){
            while (array[++i] < array[l] && i < h){}
            while (array[--j] > array[l] && j > l){}
            if(i >= j){
                break;
            }
            swap(array,i,j);

        }
        swap(array,l,j);
        return j;
    }
    private void swap(int [] array,int i, int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 最小堆
        for (int num : nums) {
            pq.add(num);
            if(pq.size()>k){  // 维护堆的大小
                pq.poll();
            }


        }
        return pq.peek();

    }
    // 其他方法
    public int findKthLargest2(int[] nums, int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
