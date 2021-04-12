package main.java.leetcode.editor.cn.DFS;

//
// 
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 518 👎 0

import javafx.util.Pair;

import java.util.Stack;

public class 省份数量{
    public static void main(String[] args){
        Solution solution = new 省份数量().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        int n = m== 0 ? 0 : isConnected[0].length;
        int count = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isConnected[i][j] != 0){
                    stack.push(new Pair(i,j));
                    isConnected[i][j] = 0;
                    count += 1;
                    while(!stack.isEmpty()){
                        Pair<Integer, Integer> top = stack.pop();
                        int r = top.getKey();
                        int c = top.getValue();
                        for(int i1 = 0; i1 < m; i1 ++){
                            if(isConnected[i1][c] != 0){
                                stack.push(new Pair<>(i1,c));
                                isConnected[i1][c] = 0;
                            }

                        }
                        for(int j1 = 0; j1 < n; j1++){
                            if(isConnected[r][j1] != 0){
                                stack.push(new Pair<>(r,j1));
                                isConnected[r][j1] = 0;
                            }
                        }
                    }
                }

            }

        }





        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
