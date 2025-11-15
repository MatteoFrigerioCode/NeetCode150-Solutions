/* https://neetcode.io/problems/top-k-elements-in-list?list=neetcode150 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occorrenze = new HashMap<>();
        // Serve per salvare tutti i numeri con le medesime occorrenze nello stesso "cestino". La lunghezza è +1 perché va da 0 a nums.length (inclusi)
        List<Integer>[] buckets = new List[nums.length + 1];

        // Inizializza i "cassetti"
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Scorre l'array dato e conta le occorrenze
        for (int current : nums) {
            occorrenze.put(current, occorrenze.getOrDefault(current, 0) + 1);
        }

        // Salva nei rispettivi cassetti tutti gli elementi
        for (Map.Entry<Integer, Integer> entry : occorrenze.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        // Crea l'array da restituire e lo popola con i k elementi più frequenti
        int[] finale = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i > 0 && index < k; i--) { 
            for (int n : buckets[i]) {
                finale[index++] = n;
                if (index == k) {
                    return finale;
                }
            }
        }

        return finale;
    }
}
