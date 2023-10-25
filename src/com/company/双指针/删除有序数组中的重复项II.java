package com.company.双指针;

import com.company.公共类.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiu
 * @create 2023-11-07 15:09
 */
public class 删除有序数组中的重复项II {
    static int removeDuplicates(int[] nums) {
        int read=2;int write=2;
        while(read<nums.length){
            if(nums[write-2]!=nums[read]){
                nums[write]=nums[read];
                write++;
            }
            read++;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums,0,write)));
        return write;
    }

    static ListNode partition(ListNode head, int x) {
        ListNode first=new ListNode(1);
        ListNode samll=first;
        ListNode second=new ListNode(1);
        ListNode large=second;
        while(head!=null){
           int val= head.val;
            if(val<x){
                samll.next=new ListNode(val);
                samll=samll.next;
            }else{
                large.next=new ListNode(val);
                large=large.next;
            }
            head=head.next;
        }
        ListNode temp=first;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=second.next;
        return first.next;
    }
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        back(nums,0);
        return res;
    }

    public static void main(String[] args) {
    }
    void back(int[] nus,int idx){
        res.add(new ArrayList<>(path));
        for (int i = idx; i < nus.length; i++) {
            if (i>idx&&nus[i]==nus[i-1])continue;
            path.add(nus[i]);
            back(nus, i+1);
            path.remove(path.size()-1);
        }
    }
}
