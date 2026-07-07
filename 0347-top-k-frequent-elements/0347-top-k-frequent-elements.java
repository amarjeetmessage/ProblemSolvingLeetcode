class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        //create hasmap
        HashMap<Integer, Integer> map = new HashMap<>();
        // hasmap store all value
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //create PriorityQueue of of hashMap type
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( (a,b) -> a.getValue() - b.getValue());
        // keep only k elements in pq
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        //create arr of k size to store ans
        int ans[] = new int[k];
        // use for loop to add key of pq in arr
        for(int i = 0; i<k; i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}