package main.java.leetcode.editor.cn.DFS;

//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。 
//
// 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。 
//
// 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。 
//
// 
//
// 提示： 
//
// 
// 输出坐标的顺序不重要 
// m 和 n 都小于150 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//给定下面的 5x5 矩阵:
//
//  太平洋 ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * 大西洋
//
//返回:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 217 👎 0

import java.util.ArrayList;
import java.util.List;

public class 太平洋大西洋水流问题{
    public static void main(String[] args){
        Solution solution = new 太平洋大西洋水流问题().new Solution();
        int[][] matrix = new int[][]{{1,2},{4,3}};
        solution.pacificAtlantic(matrix);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] visitLeftUp; // 能否到达太平洋
    boolean[][] visitRightDown;  // 能否到达大西洋
    int[] dm;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int m = matrix.length;
        int n = m>0? matrix[0].length:0;
        List res = new ArrayList<>();

        dm = new int[]{-1,0,1,0,-1};
        visitLeftUp = new boolean[m][n];
        visitRightDown = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(matrix,visitLeftUp,i,0);
            dfs(matrix,visitRightDown,i,n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(matrix,visitLeftUp,0,i);
            dfs(matrix,visitRightDown,m-1,i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visitLeftUp[i][j] && visitRightDown[i][j]){
                   List pre = new ArrayList<>();
                   pre.add(i);
                   pre.add(j);
                   res.add(pre);
                }
            }
        }
        return res;

    }

    void dfs(int[][] matrix, boolean[][] visit, int r,int c){
        if(visit[r][c]){
            return;
        }
        visit[r][c] = true;
        for (int i = 0,x = r,y = c; i < 4; i++) {
            x = r + dm[i];
            y = c + dm[i+1];
            if(x>=0 && y>= 0 && x < matrix.length && y < matrix[0].length && matrix[r][c] <= matrix[x][y]){
                dfs(matrix,visit,x,y);
            }
        }



    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
