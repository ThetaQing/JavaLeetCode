package main.java.leetcode.editor.cn.DoublePoints;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

 示例 1：

 输入：c = 5
输出：true
解释：1 * 1 + 2 * 2 = 5


 示例 2：

 输入：c = 3
输出：false


 示例 3：

 输入：c = 4
输出：true


 示例 4：

 输入：c = 2
输出：true


 示例 5：

 输入：c = 1
输出：true



 提示：


 0 <= c <= 231 - 1

 Related Topics 数学
 👍 153 👎 0
*/
public class 平方数之和{
    public static void main(String[] args){
        Solution solution = new 平方数之和().new Solution();
        long begin = System.currentTimeMillis();

        for (int i = (int)Math.pow(2,30); i < Math.pow(2,31); i=i+1000) {
            boolean re = solution.judgeSquareSum(i);
            System.out.println(i+":  "+re);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end - begin));

    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while(a<=b){
            if(a*a + b*b == c){  // 找到
                return true;
            }else if(a*a + b*b > c){  // 平方和大于c，慢指针移动,快快指针无需移动
                b -= 1;
            } else{  // 否则快指针移动
                a += 1;
            }

        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
