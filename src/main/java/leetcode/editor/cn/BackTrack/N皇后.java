package main.java.leetcode.editor.cn.BackTrack;

import java.util.*;

/**
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 834 👎 0
*/
public class N皇后{
    public static void main(String[] args){
        Solution solution = new N皇后().new Solution();
        List<List<String>> lists = solution.solveNQueues(4);
        System.out.println(lists);


    }
//leetcode submit region begin(Prohibit modification and deletion)

class Solution{
    public List<List<String>> solveNQueues(int n){
        List<List<String>> solution = new ArrayList<>();
        int[] queues = new int[n];
        Arrays.fill(queues,-1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backTrack(solution,queues,n,0,columns,diagonals1,diagonals2);
        return solution;
    }
    public void backTrack(List<List<String>> solutions,int[] queues,int n,int row,Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(row==n){
            // 生成答案
            List<String> board = generateBoard(queues,n);
            solutions.add(board);
            return;
        }else{
            for (int i = 0; i < n; i++) {
                if(columns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)){
                    continue;
                }
                queues[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                backTrack(solutions,queues,n,row+1,columns,diagonals1,diagonals2);
                // 回溯
                queues[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
        return;
    }
    public List<String> generateBoard(int[] queues,int n){
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row,'.');
            row[queues[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
