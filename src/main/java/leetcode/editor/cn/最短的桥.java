package main.java.leetcode.editor.cn;

import org.w3c.dom.Node;

import java.util.*;

/**
//在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。） 
//
// 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。 
//
// 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1 。） 
//
// 
//
// 示例 1： 
//
// 
//输入：A = [[0,1],[1,0]]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：A = [[0,1,0],[0,0,0],[0,0,1]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
//输出：1 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length == A[0].length <= 100 
// A[i][j] == 0 或 A[i][j] == 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 
// 👍 151 👎 0
*/
public class 最短的桥{
    public static void main(String[] args){
        Solution solution = new 最短的桥().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestBridge(int[][] A) {
        int R = A.length, C = A[0].length; //题目中规定了2 <= A.length == A[0].length <= 100
        int[][] colors = getComponents(A);

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> target = new HashSet<>();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(colors[r][c] == 1){
                    queue.add(new Node(r,c,0));
                }else if(colors[r][c] == 2){
                    target.add(r*C+c);
                }

            }
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (target.contains(node.r * C + node.c)) {
                return node.depth - 1;
            }
            for (Integer neighbor : neighbors(A, node.r, node.c)) {
                int nr = neighbor / C, nc = neighbor % C;
                if (colors[nr][nc] != 1) {
                    queue.add(new Node(nr, nc, node.depth + 1));
                    colors[nr][nc] = 1;
                }
            }
        }
        throw null;

    }

    public int[][] getComponents(int[][] A){
        int R = A.length,C = A[0].length;
        int[][] colors = new int[R][C];
        int t = 0;

        for (int r0 = 0; r0 < R; r0++) {
            for (int c0 = 0; c0 < C; c0++) {
                if(colors[r0][c0] == 0 && A[r0][c0] == 1){// 找到新的岛屿
                    // 开始深度优先遍历
                    Stack<Integer> stack = new Stack<>();
                    stack.push(r0*C+c0); //该节点的位置
                    colors[r0][c0] = ++t;

                    while(!stack.isEmpty()){
                        int node = stack.pop();
                        int r = node / C, c = node% C;  // 重新获取该位置的横纵坐标
                        for (Integer neighbor : neighbors(A, r, c)) {
                            int nr = neighbor/C,nc = neighbor%C;
                            if(A[nr][nc] == 1 && colors[nr][nc] == 0){  // 找到新的岛屿
                                colors[nr][nc] = t;
                                stack.push(nr*C+nc);
                            }
                        }
                    }

                }
            }
        }
        return colors;
    }

    public List<Integer> neighbors(int[][] A, int r, int c){
        int R = A.length,C = A[0].length;
        List<Integer> ans = new ArrayList<>();
        if(r-1>= 0){ans.add((r-1)*R+c);}
        if(c-1>= 0){ans.add(r*R+(c-1));}
        if(r+1<R){ans.add((r+1)*R+c);}
        if(c+1<C){ans.add(r*R+(c+1));}
        return ans;
    }
}
class Node{  // 定义节点
        int r,c,depth;
        Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.depth = d;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
