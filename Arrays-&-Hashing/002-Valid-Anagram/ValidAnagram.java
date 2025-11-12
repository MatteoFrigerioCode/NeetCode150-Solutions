/* https://neetcode.io/problems/is-anagram?list=neetcode150 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] occorrenze = new int[26];
        for (int i = 0; i < s.length(); i++) {
            occorrenze[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (occorrenze[t.charAt(i) - 'a'] == 0) {
                return false;
            }
            occorrenze[t.charAt(i) - 'a']--;   
        }

        return true;
    }
}
