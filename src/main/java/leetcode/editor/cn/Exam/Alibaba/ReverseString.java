package main.java.leetcode.editor.cn.Exam.Alibaba;

public class ReverseString {
    public static void main(String[] args) {
        String s = reverse("ali all in, Ali ila");
        System.out.println(s);

    }

    public static String reverse(String str){
        char[] chars = str.toCharArray();
        String res = "";
        for(int i = chars.length - 1; i >= 0; i--){
            if(chars[i] == 'i'){
                if(i-1 >= 0 && chars[i-1] == 'l'){
                    if(i-2 >= 0 && chars[i-2] == 'a'){
                        res += chars[i-2];
                        res += chars[i-1];
                        res += chars[i];
                        i = i-2;
                        continue;
                    }
                }
            }
            res += chars[i];

        }
        return res;

    }

    public static String reverseH(String s){
        char[] chars =s.toCharArray();
        int i=0,j=s.length()-1;
        while (i<j){
            swapH(chars,i,j);
            i++;
            j--;
        }
        int left=0;

        while (left<s.length()-2){
            if (String.valueOf(chars,left,3).equals("ila")){
                swapH(chars,left,left+2);
            }
            left++;
        }
        return new String(chars);
    }
    public static void  swapH(char[] chars,int i,int j){
        char temp =chars[i];
        chars[i]=chars[j];
        chars[j]=temp;

    }

    public static String reverse2(String str){
        // 先全部反转
        char[] chars = str.toCharArray();
        int i = 0;
        int j = str.length()-1;
        while(i < j){
            // 交换
            swap(chars,i,j);  // todo
            i++;j--;

        }
        // 再遍历查找ila
        int left = 0;
        while(left < str.length() -2){
            // 查找是否有 ila组合
            if(String.valueOf(chars,left,3).equals("ila")){
                swap(chars, left, left + 2);  // todo

            }
            left++;

        }
        return new String(chars);

    }

    public static void swap(char[] chars,int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;

    }


}
