/* https://neetcode.io/problems/duplicate-integer?list=neetcode150 */
class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numbers.add(nums[i])) {
                return true;
            }
        }
        return false;    
    }
}
