/* https://neetcode.io/problems/string-encode-and-decode/question?list=neetcode150 */
class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        // Salva le lunghezze delle stringhe
        for (String str : strs) {
            sizes.add(str.length());
        }

        // Salva le lunghezze separate da una "," nella stringa da restituire
        for(int size : sizes) {
            res.append(size).append(',');
        }
        // Aggiunge il carattere "#" per distinguere dove finisce l'header
        res.append('#');

        // Concatena tutte le stringhe
        for (String str : strs) {
            res.append(str);
        }

        return res.toString();
    }

    public List<String> decode(String str) {
        // Controlla se la stringa sia nulla
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        int i = 0;

        // Scorre la stringa ricevuta salvando le lunghezze lette, fermandosi quando incontra '#'
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        // Seleziona il primo carattere dopo '#'
        i++;
        for (int size : sizes) {
            res.add(str.substring(i, i + size));
            i += size;
        }

        return res;
    }
}
