package main.java.leetcode.editor.cn.DFS;

//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 461 👎 0

import javafx.util.Pair;

import java.util.Stack;

public class 岛屿的最大面积{
    public static void main(String[] args){
        Solution solution = new 岛屿的最大面积().new Solution();
        int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0}, {0,0,0,1,1},{0,0,0,1,1}};
        int[][] grid1 = new int[][]{{0,0,1,0,1,1,1,0},{1,0,0,0,1,0,1,0},{0,0,1,1,0,0,1,0},{1,1,1,1,0,1,1,0},{1,1,0,1,1,0,1,0}};
        int i = solution.maxAreaOfIsland(grid1);
        System.out.println(i);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = m== 0 ? 0 : grid[0].length;
        int area = 0;
        int maxArea = 0;
        int[] dm = new int[]{-1,0,1,0};
        int[] dn = new int[]{0,1,0,-1};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){  // 遍历所有搜索的位置
                // 判断是否开始搜索
                if(grid[i][j] != 0){

                    Stack<Pair<Integer,Integer>> stack = new Stack();
                    stack.push(new Pair<>(i,j));
                    grid[i][j] = 0;  // 标记已遍历
                    area = 1;
                    while(!stack.isEmpty()){
                        Pair<Integer, Integer> pop = stack.pop();
                        int pi = pop.getKey();  // 获取此时遍历的位置坐标
                        int pj = pop.getValue();
                        for(int i1 = 0; i1 < 4;i1++){
                            if(pi+dm[i1] >= 0 && pi+dm[i1] < m && pj+dn[i1] >= 0 && pj+dn[i1]< n && grid[pi+dm[i1]][pj+dn[i1]] != 0){
                                grid[pi+dm[i1]][pj+dn[i1]] = 0;  // 标记已遍历
                                area += 1;
                                stack.push(new Pair<>(pi+dm[i1],pj+dn[i1]));
                            }
                        }
                    }

                }
                maxArea = Math.max(maxArea,area);

            }
        }

        return maxArea;


    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
