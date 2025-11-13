/* https://neetcode.io/problems/anagram-groups?list=neetcode150 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> elencoAnagrammi = new ArrayList<>();
        HashMap<String, ArrayList<String>> anagrammiParole = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] parola = strs[i].toCharArray();
            Arrays.sort(parola);
            String parolaOrdinata = String.valueOf(parola);

            if (anagrammiParole.containsKey(parolaOrdinata)) {
                anagrammiParole.get(parolaOrdinata).add(strs[i]);
            }
            else {
                ArrayList<String> parole = new ArrayList<>();
                parole.add(strs[i]);
                anagrammiParole.put(parolaOrdinata, parole);
            }
        }

        for (String s : anagrammiParole.keySet()) {
            elencoAnagrammi.add(anagrammiParole.get(s));
        }

        return elencoAnagrammi; 
    }
}
