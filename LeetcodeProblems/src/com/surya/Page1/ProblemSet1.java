package com.surya.Page1;

import java.util.Arrays;
import java.util.HashMap;

public class ProblemSet1 {

	/*
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific 
	 * target.You may assume that each input would have exactly one solution, and you may not use the 
	 * same element twice
	 */
	 public int[] twoSum(int[] nums, int target) {
	        int[] result = new int[2];
	        int len = nums.length;
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i=0;i<len;i++){
	            int temp = nums[i];
	            if(!map.containsKey(target-temp)){
	                map.put(temp,i);
	            }else{
	              result[0] = map.get(target-temp) ;
	              result[1] = i;
	              return result;  
	            }
	        }
	        return result;
	    }
	 
	 /**
	  * You are given two non-empty linked lists representing two non-negative integers. The digits
	  * are stored in reverse order and each of their nodes contain a single digit. Add the two 
	  * numbers and return it as a linked list.You may assume the two numbers do not contain any 
	  * leading zero, except the number 0 itself. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	  * Output: 7 -> 0 -> 8
	  */
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode result = new ListNode(0);
	        ListNode temp = result;
	        int carry = 0; 
	        while(l1!=null || l2!=null){
	            int x = (l1!=null)?l1.val:0;
	            int y = (l2!=null)?l2.val:0;
	            int sum = carry+x+y;
	            carry=sum/10;
	            temp.next=new ListNode(sum%10);
	            temp=temp.next;
	            if(l1!=null) l1=l1.next;
	            if(l2!=null) l2=l2.next;
	        }
	        if (carry > 0) {
				temp.next = new ListNode(carry);
			}
	        return result.next;
	    }
	 
	 
	 
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode res = new ProblemSet1().addTwoNumbers(l1, l2);
		System.out.println(res.val+"->"+res.next.val+"->"+res.next.next.val);

	}

}


class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		val = x;
	}
}
