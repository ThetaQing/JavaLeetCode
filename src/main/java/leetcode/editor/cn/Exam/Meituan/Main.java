package main.java.leetcode.editor.cn.Exam.Meituan;

import javafx.util.Pair;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static String solve(String s){
        char[] chars = s.toCharArray();
        int m = chars.length;
        ArrayList<Pair<Integer,Integer>> index = new ArrayList<>();
        for (int i = 0,j = m-1; i <= j ; i++,j--) {
            if(chars[i] == chars[j]){
                continue;
            }
            index.add(new Pair<>(i,j));
        }
        if(index.isEmpty()){
            return new String(chars);
        }
        if(index.size() == 1){
            Pair<Integer, Integer> pair = index.get(0);
            int leftIndex = pair.getKey();
            int rightIndex = pair.getValue();
            if(chars[leftIndex] > chars[rightIndex]){
                chars[leftIndex] = chars[rightIndex];
            }else{
                chars[rightIndex] = chars[leftIndex];
            }
        }else{
            int leftIndex = 0;
            for (Pair<Integer, Integer> pair : index) {
                leftIndex = pair.getKey();
                if(chars[leftIndex] != '0'){
                    chars[leftIndex] = '0';
                    return new String(chars);
                }
            }
            while(leftIndex <= m-1){
                if(chars[leftIndex] != '0'){
                    chars[leftIndex] = '0';
                    return new String(chars);
                }
                leftIndex++;
            }


        }
        return new String(chars);


    }






    static Map<Integer,Integer> firstMap = new HashMap<>();
    static Map<Integer,Integer> lastMap = new HashMap<>();

    public static void init(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            lastMap.put(nums[i],i+1);

        }
       for (int i = nums.length-1; i >= 0; i--) {
            firstMap.put(nums[i],i+1);
        }
    }
    public static void search(int[] nums1){
        for (int i = 0; i < nums1.length; i++) {
            if(firstMap.get(nums1[i]) == null){
                System.out.println(0);
            }else{
                System.out.println(firstMap.get(nums1[i])+" "+lastMap.get(nums1[i]));
            }
        }
    }

    public static void main2(String[] args){
        Scanner input  = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        init(nums);
        int[] nums1 = new int[m];
        for (int i = 0; i < m; i++) {
            nums1[i] = input.nextInt();
        }
        search(nums1);

    }

    public static String minString(String s){
        boolean flag = true;
        int n = s.length();
        int i = 0, j = n - 1;
        if(isValid(s,0,j)){
            return s;
        }
        int left = -1;int right = -1;
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j)) {

                flag = isValid(s, i + 1, j - 1);

                left = i;
                right = j;
                break;
            }
            i++;
            j--;
        }
        char[] res = s.toCharArray();
        if(flag == false){
            return new String(toString(res));
        }
        else{
            if(res[right] < res[left]){
                res[left] = res[right];
                return new String(res);
            }else{
                res[right] = res[left];
                return new String(res);

            }
        }

    }
    public static char[] toString(char[] res){
        int i = 0;
        while(res[i] == '0'){
            i++;
        }
        res[i] = '0';
        return res;
    }
    public static boolean isValid(String s,int i, int j){
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            res.add(scanner.next());
        }
        for(String s:res){
            System.out.println(minString(s));
        }
    }

}
