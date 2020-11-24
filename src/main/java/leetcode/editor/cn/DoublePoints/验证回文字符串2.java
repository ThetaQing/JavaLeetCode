package main.java.leetcode.editor.cn.DoublePoints;
/**
给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

 示例 1:


输入: "aba"
输出: True


 示例 2:


输入: "abca"
输出: True
解释: 你可以删除c字符。


 注意:


 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。

 Related Topics 字符串
 👍 283 👎 0
*/
public class 验证回文字符串2{
    public static void main(String[] args){
        Solution solution = new 验证回文字符串2().new Solution();
        System.out.println(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        boolean flag = true; // 第一次任意删除前指针指向的字符，删除后标志位不可用
        boolean flag2 = true;  // 第一次删除后仍然不是回文数，修改第一次删除的字符，选择从另一方向删除，删除后标志位不可用
        int front = 0;
        int charLen = chars.length;
        int back = charLen-1;
        int deleteIndexB = -1;
        int deleteIndexF = -1;
        while (front<=back ){
            if(chars[front] == chars[back]){
                front++;
                back--;
            }else if(front<back && chars[front+1]==chars[back] && flag){
                flag = false;
                deleteIndexF = front;  // 记录此时删除的字符索引
                front++;
            }else if(back>front && chars[front] == chars[back - 1] && flag){
                flag = false;
                deleteIndexB = back;  // 记录此时删除的字符索引
                back--;
            }else if(!flag && flag2){  // 如果第一次删除后判断字符串不是回文串，则修改删除方向
                // 这里的指针是指删除之后的新一轮迭代的指针
                front = deleteIndexF==-1?(charLen-deleteIndexB):deleteIndexF;  // 如果第一次删除的是前指针指向的字符，则新的前指针原删除的字符索引，否则为当初删除的后指针指向的字符所对应的前指针的下一个字符
                back = deleteIndexF==-1?deleteIndexB:(charLen-deleteIndexF-2);  // 类似
                flag2 = false;
            }
            else{
                return false;
            }
        }
        return true;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
