package main.java.leetcode.editor.cn;



import java.util.ArrayList;
import java.util.List;

/**
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。



 示例：


输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。




 提示：


 S的长度在[1, 500]之间。
 S只包含小写字母 'a' 到 'z' 。

 Related Topics 贪心算法 双指针
 👍 399 👎 0
*/
public class 划分字母区间{
    public static void main(String[] args){
        //Solution solution = new 划分字母区间().new Solution();
        String str1 = "abc";
        String str2 = "aad";
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
    class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndexsOfChar = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexsOfChar[char2Index(S.charAt(i))] = i;
        }
        ArrayList<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while(firstIndex < S.length()){
            int lastIndex = firstIndex;
            String str1 = "1";
            String str2 = "2";
            str1.hashCode();

        }


    }
    private int char2Index(char c){
        return c - 'a';
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)

}
