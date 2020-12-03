package main.java.leetcode.editor.cn.Sort;

import java.util.*;

/**
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。



 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]


 示例 2:

 输入: nums = [1], k = 1
输出: [1]



 提示：


 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 你可以按任意顺序返回答案。

 Related Topics 堆 哈希表
 👍 574 👎 0

 解题思路
 设置若干个桶，每个桶存储出现频率相同的数。桶的下标表示数出现的频率，即第 i 个桶中存储的数出现的频率为 i。

 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。

 1、建立数与频数之间的哈希表；
 2、将频数为i的数存入到下标为i的桶中（桶要用链表，频数可能相同）
 3、从后往前遍历桶，最先得到的k个数即为出现频数最多的k个数。
*/
public class 前K个高频元素{
    public static void main(String[] args){

        Solution solution = new 前K个高频元素().new Solution();
        int[] topK = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3,4,4,4,1,5,6,7}, 2);
        System.out.println(topK);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequencyForNum = new HashMap<>();

        // 先建立每个数与出现频数的映射关系
        for (int num : nums) {
            frequencyForNum.put(num,frequencyForNum.getOrDefault(num,0)+1);
        }
        // 第i个桶存储的数出现的频率为i
        // 用链表数组，因为频数可能相同
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : frequencyForNum.keySet()) {
            Integer frequency = frequencyForNum.get(key);
            // 给这个桶分配内存
            if(buckets[frequency] == null){
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
            int length = buckets.length;
        }
        List<Integer> topK = new ArrayList<>();
        for(int i = buckets.length - 1; i >= 0 && topK.size() < k;i--){
            if(buckets[i] == null){
                continue;
            }
            // 如果该链表的size小于k - topK.size()，可以全部将该链表的内容加入到topK中
            if(buckets[i].size() <= (k - topK.size())){
                topK.addAll(buckets[i]);
            }else{
                topK.addAll(buckets[i].subList(0,k-topK.size()));
            }

        }
        // 数组拆箱
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;



    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
