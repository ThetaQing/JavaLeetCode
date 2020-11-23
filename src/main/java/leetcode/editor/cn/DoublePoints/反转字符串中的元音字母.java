package main.java.leetcode.editor.cn.DoublePoints;


import java.lang.String;
import java.lang.Character;
/**
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。



 示例 1：

 输入："hello"
输出："holle"


 示例 2：

 输入："leetcode"
输出："leotcede"



 提示：


 元音字母不包含字母 "y" 。

 Related Topics 双指针 字符串
 👍 126 👎 0
*/
public class 反转字符串中的元音字母{
    public static void main(String[] args){
        Solution solution = new 反转字符串中的元音字母().new Solution();
        System.out.println(solution.reverseVowels("AaEeIiOoUu"));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        int front = 0;
        int back = s.length()-1;
        char[] chars = s.toCharArray();


        while (front<=back){
            Character frontChar = chars[front];
            Character backChar = chars[back];
            Character temp;

            if(isVowel(frontChar)){
                while(back >= front && (!isVowel(backChar))){
                    back -= 1;
                    backChar = chars[back];
                }
                if(isVowel(backChar)){
                    temp = frontChar;
                    chars[front] = backChar;
                    chars[back] = temp;
                    front += 1;
                    back -= 1;
                }

            }else{
                front += 1;
            }

        }

        return new String(chars);

    }
    public boolean isVowel(char ch){  // 判断是否是元音字母
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
