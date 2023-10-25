package com.company.二叉树;

/**
 * @author xiu
 * @create 2023-11-10 22:16
 */
public class WordDictionary {
    Trie root;
    public WordDictionary() {
        root=new Trie();
    }

    public void addWord(String word) {
        root.add(word);
    }

    public boolean search(String word) {
        return root.search(word);
    }

}
class Trie {
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
            Trie next = root.child[c - 'a'];
            if (next!=null&&dfs(word, idx+1, next)){
                return true;
            }
        }else{
            Trie[] childlist = root.child;
            for (Trie child:childlist) {
                if (child!=null&&dfs(word, idx+1, child)){
                    return true;
                }
            }
        }
        return false;
    }
//    public static void main(String[] args) {
//        System.out.println(findKthLargest(new int[]{888, 6, 1, 5, 2, 0}, 1));
//    }
//    static int findKthLargest(int[] nums, int k) {
////        return quick(nums, 0, nums.length - 1, k);
//    }
//    static Integer quick(int[] nums,int left,int right,int k){
//        int target= nums.length-k;
//        int l=left;int r=right-1;
//        while (l<=r){
//            if ()
//        }
//    }
}
