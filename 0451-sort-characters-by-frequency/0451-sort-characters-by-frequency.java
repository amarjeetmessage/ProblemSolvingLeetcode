class Solution {
    public String frequencySort(String s) {

        // Step 1: Count frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Max Heap based on character frequency
        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Add all unique characters into the heap
        pq.addAll(map.keySet());

        // Step 3: Build the answer
        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            // Append the character 'freq' times
            while (freq-- > 0) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}