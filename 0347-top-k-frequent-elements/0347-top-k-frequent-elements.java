class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Store frequency of every number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>(
                        (a, b) -> a.getValue() - b.getValue()
                );

        // Step 3: Insert every entry into heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            pq.offer(entry);

            // Keep only k elements
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Store answer
        int[] ans = new int[k];

        // Remove elements from heap
        // for (int i = k - 1; i >= 0; i--) {
        //     ans[i] = pq.poll().getKey();
        // }
        for(int i = 0; i<k; i++){
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}