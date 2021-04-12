package main.java.leetcode.editor.cn.Exam.Tencent;

import java.util.Arrays;
import java.util.Scanner;

public class TensentTest {

    class ListNode { int val;
    ListNode next = null;
    public ListNode(int val) {
     this.val = val;
   }
  }


      class TreeNode {
        int val = 0;
        TreeNode left = null;
       TreeNode right = null;
       public TreeNode(int val) {
         this.val = val;
       }
    }
            /**
             * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
             * 你需要返回m个指针，第i个指针指向一条链，表示第i个问题的答案
             * @param root TreeNode类 指向链表树的根
             * @param b int整型一维数组 表示每个问题是什么
             * @return ListNode类一维数组
             */

        public ListNode[] solve (TreeNode root, int[] b) {
            // write code here
            ListNode[] res = new ListNode[b.length];
            ListNode pre = new ListNode(root.val);
            if(root == null){
                return res;
            }
            for(int i = 0; i < b.length; i++){
                if(root.val == b[i]){
                    res[i].next = pre;
                }else{


                }

            }
            return  res;


        }
    public static int solve (int k){
        if(k <= 0){
            return 0;
        }
        int[] pre = new int[k+1];
        Arrays.fill(pre,k+1);
        pre[0] = 0;
        for(int i = 1; i <= k; i++){
            if(i%2 == 0){
                pre[i] = Math.min(pre[i-1]+1,pre[i/2]+1);
            }
            if(i%3 == 0){
                pre[i] = Math.min(Math.min(pre[i],pre[i-1]+1),pre[i/3]+1);

            }
            pre[i] = pre[i] == k+1 ? pre[i-1]+1: pre[i];
        }
        return pre[k];

    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int res= 0;
        for(int i = 0; i < t; i++){
            res = solve(sc.nextInt());
            System.out.println(res);
        }
    }



    public static int solve (int[] prices,int m){
        int sum = Arrays.stream(prices).sum();
        Arrays.sort(prices);
        if(sum % m == 0){
            return 0;
        }
        int res = sum;
       int [] pre = new int[prices.length+1];
        Arrays.fill(pre,sum);
        for(int i = 1; sum % m != 0;i++){
            for(int j = 0; j < prices.length;j++){
                if((sum - prices[j]) % m == 0){
                    pre[i] = Math.min(pre[i],prices[j]);
                }
            }

        }
        return res;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[] prices = new int[n];
            int m = sc.nextInt();
            for(int j = 0; j < n; j++){
                prices[j] = sc.nextInt();
            }
            int res = solve(prices,m);
            System.out.println(res);
        }
    }


}
