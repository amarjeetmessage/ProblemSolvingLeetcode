class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // put in priority queue and find the min and max 
        // add all element in set 
        // loop over the set and if not contains in range add to list
        // sort them
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<n; i++){
            pq.offer(nums[i]);
        }

        int min = pq.peek();
        int max = 0;
        for(int i = 0; i<n; i++){
            if(!pq.isEmpty()){
                max = pq.peek();
                pq.poll();
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>();
        for(int i = min; i<max; i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }

        Collections.sort(list);

        return list;
        

    }
}