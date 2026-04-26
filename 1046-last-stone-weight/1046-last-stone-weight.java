// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         int n = stones.length;
//         //arraylist to modify 
//         List<Integer> arr = new ArrayList<>();
//         for(int i = 0; i<n; i++){
//             arr.add(stones[i]);
//         }

//         while (arr.size() > 1) {
//             Collections.sort(arr);
//             int a = arr.remove(arr.size() - 1);
//             int b = arr.remove(arr.size() - 1);

//             if(a > b){
//                 arr.add(a - b);
//             }
//         }
//         if(arr.size() == 1){
//             return arr.get(0);
//         }else return 0;
//     }
// }




// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         List<Integer> arr = new ArrayList<>();

//         for (int stone : stones) {
//             arr.add(stone);
//         }

//         while (arr.size() > 1) {
//             Collections.sort(arr);

//             int a = arr.remove(arr.size() - 1); // largest
//             int b = arr.remove(arr.size() - 1); // second largest

//             if (a != b) {
//                 arr.add(a - b);
//             }
//         }

//         return arr.isEmpty() ? 0 : arr.get(0);
//     }
// }





// //USING HEAPS PATTERN 

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<stones.length; i++){
            pq.offer(stones[i]);
        }

        while (pq.size() > 1) {
            int a = pq.remove();
            int b = pq.poll();

            if(a > b){
                pq.add(a - b);
            }
        }
        if(pq.size() == 1){
            return pq.peek();
        }else return 0;
    }
}