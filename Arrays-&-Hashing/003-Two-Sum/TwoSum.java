/* https://neetcode.io/problems/two-integer-sum?list=neetcode150 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numeriLetti = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (numeriLetti.containsKey(x)) {
                return new int[] {numeriLetti.get(x), i};
            }
            numeriLetti.put(nums[i], i);    
        }   
        return null;
    }
}
