package main.java.leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 550 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 组合{
    public static void main(String[] args){
        Solution solution = new 组合().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Stack<Integer> pre = new Stack<>();
    public List<List<Integer>> combine(int n, int k) {

        backTrack(n,1,k);
        return res;
    }
    public void backTrack(int n, int num, int k){
        if(n-num<=k){
            return;
        }
        if(k<=0){
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = num; i <= n; i++) {
            pre.push(i);
            backTrack(n,num+1,k-1);
            pre.pop();
            backTrack(n,num+1,k);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
