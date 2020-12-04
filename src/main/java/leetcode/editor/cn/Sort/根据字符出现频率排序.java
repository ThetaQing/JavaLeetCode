package main.java.leetcode.editor.cn.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

 示例 1:


输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。


 示例 2:


输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。


 示例 3:


输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。

 Related Topics 堆 哈希表
 👍 187 👎 0
*/
public class 根据字符出现频率排序{
    public static void main(String[] args){
        Solution solution = new 根据字符出现频率排序().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {

        char[] chars = s.toCharArray();
        // 频数与字母对应
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char aChar : chars) {
            frequencyMap.put(aChar,frequencyMap.getOrDefault(aChar,0)+1);
        }
        // 第i个桶存储频数为i的字母
        List<Character>[] buckets = new ArrayList[chars.length + 1];
        for (Character character : frequencyMap.keySet()) {
            Integer frequncy = frequencyMap.get(character);
            if(buckets[frequncy] == null){
                buckets[frequncy] = new ArrayList<>();
            }
            buckets[frequncy].add(character);

        }
        // 按顺序取出
        StringBuilder res = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0 ; i--) {
            if(buckets[i] ==null){
                continue;
            }
            for(char c:buckets[i]){
                for(int j = i; j > 0; j--){
                    res.append(c);
                    //res += buckets[i].get(i1);
                }

            }

        }


        return res.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
