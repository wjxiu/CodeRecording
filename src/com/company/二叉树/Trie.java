//package com.company.二叉树;
//
///**
// * @author xiu
// * @create 2023-11-10 21:05
// */
//public class Trie {
//     Trie[] child;
//    boolean isend;
//
//    public Trie() {
//        child = new Trie[26];
//    }
//
//    public void insert(String word) {
//        char[] charArray = word.toCharArray();
//        Trie temp = this;
//        for (char c : charArray) {
//            int index = c - 'a';
//            if (temp.child[index] == null) {
//                temp.child[index] = new Trie();
//            }
//            temp = temp.child[index];
//        }
//        temp.isend = true;
//    }
//
//    public boolean search(String word) {
//        Trie trie = searchPrefix(word);
//        return trie!=null&&trie.isend;
//    }
//
//    public boolean startsWith(String prefix) {
//        return searchPrefix(prefix) != null;
//    }
//
//    private Trie searchPrefix(String prefix) {
//        Trie temp = this;
//        char[] charArray = prefix.toCharArray();
//        for (char c : charArray) {
//            int index = c - 'a';
//            if (temp.child[index] == null) return null;
//            temp = temp.child[index];
//        }
//        return temp;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(minSubArrayLen(4, new int[]{1,4,4}));
//    }
//    static int minSubArrayLen(int target, int[] nums) {
//        int left=0;int right=0;int sum=0;int res=Integer.MAX_VALUE;
//        while (right< nums.length){
//            sum+=nums[right];
//            while(sum>=target&&left<=right){
//                res=Math.min(right-left+1,res);
//                sum-=nums[left];
//                left++;
//            }
//            right++;
//        }
//        return res==Integer.MAX_VALUE?0:res;
//    }
//}
public class Trie {
    Trie[] child;
    boolean isend;

    Trie() {
        child = new Trie[26];
    }
    public void add(String word) {
        char[] charArray = word.toCharArray();
        Trie temp=this;
        for(char c:charArray){
            int index=c-'a';
            if (temp.child[index]==null){
                temp.child[index]=new Trie();
            }
            temp=temp.child[index];
        }
        temp.isend=true;
    }

    public boolean search(String word) {
       return dfs(word,0,this);
    }
    boolean dfs(String word,int idx,Trie root) {
        if (idx==word.length())return root.isend;
        char c = word.charAt(idx);
        if (Character.isLetter(c)){
           if (root!=null&&dfs(word, idx+1, root.child[c-'a'])){
               return true;
           }
        }else{
            Trie[] childlist = root.child;
            for (Trie child:childlist) {
                if (root!=null&&dfs(word, idx+1, child)){
                    return true;
                }
            }
        }
        return false;
    }
}