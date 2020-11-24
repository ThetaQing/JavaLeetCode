package main.java.leetcode.editor.cn.DoublePoints;
/**
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 如果答案不止一个，返回长度最长且字典顺序最小的字符
串。如果答案不存在，则返回空字符串。

 示例 1:


输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出:
"apple"


 示例 2:


输入:
s = "abpcplea", d = ["a","b","c"]

输出:
"a"


 说明:


 所有输入的字符串只包含小写字母。
 字典的大小不会超过 1000。
 所有输入的字符串长度不会超过 1000。

 Related Topics 排序 双指针
 👍 109 👎 0
*/
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class 通过删除字母匹配到字典里最长单词{
    public static void main(String[] args){
        Solution solution = new 通过删除字母匹配到字典里最长单词().new Solution();
        List<String> strings = new ArrayList<String>();
        strings.add("ab");
        strings.add("ba");
        strings.add("a");
        strings.add("b");
        System.out.println(solution.findLongestWord("bab", strings));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> d) {
        char[] listS;
        char[] maxS = "".toCharArray();
        char[] chars = s.toCharArray();
        int sLen = chars.length;

        int sIndex = 0;
        int listSIndex = 0;
        ListIterator<String> sLI = d.listIterator();
        while (sLI.hasNext()){
            listS = sLI.next().toCharArray();
            sIndex = 0;
            listSIndex = 0;
            while (sIndex<sLen){
                if(listSIndex < listS.length && chars[sIndex] == listS[listSIndex]){
                    listSIndex += 1;

                }
                if(listSIndex == listS.length){  // 找到了匹配的单词
                    if(maxS.length == listS.length){  // 比较字典序
                        for (int i = 0; i < maxS.length; i++) {
                            if(maxS[i] - listS[i] > 0){
                                maxS = listS;
                                break;
                            }else if(maxS[i] - listS[i] < 0){
                                break;
                            }
                        }

                    }else{
                        maxS = maxS.length > listS.length ? maxS : listS;  // 如果当前数组长度大于maxS，更新maxS
                    }
                    break;
                }
                sIndex ++;
            }

        }
        return new String(maxS);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
