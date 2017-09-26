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
	public static void main(String[] args) {
		int[] testArray = {2,5,7,14};
		int target =9;
		int[] result  = new ProblemSet1().twoSum(testArray, target);
		System.out.println(Arrays.toString(result));

	}

}
