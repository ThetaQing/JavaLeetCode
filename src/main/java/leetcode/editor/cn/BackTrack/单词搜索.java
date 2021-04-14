package main.java.leetcode.editor.cn.BackTrack;

/**
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯算法 
// 👍 863 👎 0
*/
public class 单词搜索{
    public static void main(String[] args){
        Solution solution = new 单词搜索().new Solution();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean bc = solution.exist(board, "ABCCED");
        System.out.println(bc);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        boolean[][] isVisit;
        boolean flag;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        flag = false;

        if(m == 0){
            return false;
        }
        int n = board[0].length;
        isVisit = new boolean[m][n];
        char[] words = word.toCharArray();
        if(words.length>m*n){
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == words[0]){
                    find(board,i,j,words,1);
                    if(flag){
                        return flag;
                    }
                }
            }
        }

        return flag;
    }

    // 判断一个字母的上下左右是否含有待查询的字母
    public void find(char[][] board,int r,int c,char[] words,int num){
        if(num >= words.length){  // 如果搜索到了最后一个字母，完成查找
            flag = true;
            return ;
        }
        int[] directions = new int[]{-1,0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            if(r+directions[i] >=0 && r+directions[i]<isVisit.length && c+directions[i+1] >= 0 && c+directions[i+1] < isVisit[0].length && !isVisit[r+directions[i]][c+directions[i+1]] && !flag && board[r+directions[i]][c+directions[i+1]] == words[num]){  // 第num个字母没有被搜索过，并且相等
                isVisit[r+directions[i]][c+directions[i+1]] = true;
                find(board,r+directions[i],c+directions[i+1],words,num+1);  // 对单词下一个位置开始遍历
                isVisit[r+directions[i]][c+directions[i+1]] = false;
            }else if(flag){
                return;
            }

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
