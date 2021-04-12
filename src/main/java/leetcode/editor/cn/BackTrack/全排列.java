package main.java.leetcode.editor.cn.BackTrack;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1238 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 全排列{
    public static void main(String[] args){
        Solution solution = new 全排列().new Solution();
        List<List<Integer>> permute = solution.permute(new int[]{1, 2, 3});
       // System.out.println(permute);

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> pre = Arrays.stream(nums).boxed().collect(Collectors.toList());
        res = new ArrayList<List<Integer>>();
        backTrack(pre,0);
        return res;
    }

    public void backTrack(List<Integer> nums, int level){
        if(level == nums.size()-1){
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int i = level; i < nums.size(); i++) {
            Collections.swap(nums,i,level);  // 从未确定位置的地方开始
            backTrack(nums,level+1);  // 递归遍历
            Collections.swap(nums,i,level);  // 还原位置

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
