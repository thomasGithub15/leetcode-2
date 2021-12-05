/*
491. Increasing Subsequences
Medium

1264

145

Add to List

Share
Given an integer array nums, return all the different possible increasing subsequences of the given array with at least two elements. You may return the answer in any order.

The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100
*/
class 491Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> curr = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        backtrack(nums, curr, 0, ans);
        return ans;
    }
    public void backtrack(int[] nums, List<Integer> curr, int index, List<List<Integer>> ans){
           if(index == nums.length){
               List<Integer> t = new ArrayList<Integer>();
               t = curr;
               ans.add(t);
               return;
           }
           if(index == 0){
               curr.add(nums[index]);
               index = 1;
           }        
           for(int i = index; i < nums.length; i++){               
                 if(curr.get(curr.size() - 1) <= nums[i]){
                    curr.add(nums[i]);
                 }
               
               backtrack(nums,curr,index + 1, ans);
               curr.remove(curr.size()-1);
           }

    }
}