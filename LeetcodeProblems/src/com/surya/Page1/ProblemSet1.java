package com.surya.Page1;

import java.util.Arrays;
import java.util.HashMap;

public class ProblemSet1 {

	/**
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
	 
	 /**
	  * Given a string, find the length of the longest substring without repeating characters.
	  * @param s - Input String
	  * @return - The length of longest substring
	  * ALTERNATIVE SOLUTION IS TO USE AN ARRAY AND PUT VALUE OF COUNTER WITH ALL ELEMENTS
	  */
	 public int lengthLongestSubstr(String s){ 
		 HashMap<Character, Integer > map = new HashMap<Character, Integer>();
		 String tempLongest ="";
		 String longest = "";
		 int lenTemp = 0;
		 int lenFinal =0;
		 for(int i = 0;i<s.length();i++){
			 char c = s.charAt(i);
			 //check if not duplicate
			 if(!(map.containsKey(s.charAt(i)))){
				 map.put(c, 1);
				 tempLongest +=c;
				 lenTemp+=1;
				 
			 }else{
				 //map = new HashMap<Character, Integer>();
				 map.put(c, 1);
				 int index = tempLongest.indexOf(c);
				 tempLongest = tempLongest.substring(index+1)+c;
				 lenTemp -=index;
				 
			 }if(lenTemp>lenFinal){lenFinal=lenTemp; longest=tempLongest;}
			 
		 }
		 System.out.println(longest);
		 return lenFinal;
	 }
	 
	 /**
	  * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	  * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
	  * @param a - First Array
	  * @param b - Second Array
	  * @return - The double median of both arrays
	  */
	 public double findMedianSortedArrays(int[] a, int[] b) {
	        int[] c = new int[a.length+b.length];
	        System.arraycopy(a,0,c,0,a.length);
	        System.arraycopy(b,0,c,a.length,b.length);
	        Arrays.sort(c);
	        int len = c.length;
	        double result = (len%2==0)?(double)(c[(len-1)/2]+c[((len-1)/2)+1])/2:c[len/2];
	        return result;
	    }
	 
	 
	 
	 
	 
	 
	
	public static void main(String[] args) {
		/*ListNode l1 = new ListNode(2);
		l1.next=new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next=new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode res = new ProblemSet1().addTwoNumbers(l1, l2);
		System.out.println(res.val+"->"+res.next.val+"->"+res.next.next.val);
		System.out.println(new ProblemSet1().lengthLongestSubstr("abcdebxb"));
		int[] a = {1,3}; int[] b ={2};
		System.out.println(new ProblemSet1().findMedianSortedArrays(a, b));*/

	}

}


class ListNode{
	int val;
	ListNode next;
	public ListNode(int x){
		val = x;
	}
}
