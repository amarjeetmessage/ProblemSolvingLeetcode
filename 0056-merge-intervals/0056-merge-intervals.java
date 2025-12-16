class Solution {
    public static boolean isOverlap(int[] intr1, int[] intr2) {
            return intr1[1] >= intr2[0] && intr2[1] >= intr1[0];
    }
    public int[][] merge(int[][] intervals) {
        
        //brute force approach

        /*
        
        algo : pair wise interval comparison
        //  if merge happen {
            need to check more times again
        }else{
            no need to check more
        }
        return all intervals


        */
        List<int[]> list = new ArrayList<>();
        
        for(int[] interval : intervals) {
            list.add(interval);
        }
        //here need to copy in list b/c fixed array can not dynamic changable

        boolean isMergeHappened = true;
        
        while(isMergeHappened) {
            isMergeHappened = false;
            for(int i = 0; i < list.size(); i++) {
                int j = i + 1;
                while(j < list.size()) {
                    int[] intr1 = list.get(i);   
                    int[] intr2 = list.get(j);   

                    //intr1 = [s1, e1];
                    //intr2 = [s2, e2];
                    if(isOverlap(intr1, intr2)) {

                        intr1[0] = Math.min(intr1[0], intr2[0]);
                        intr1[1] = Math.max(intr1[1], intr2[1]);

                        list.remove(j);

                        isMergeHappened = true;

                    }else {
                        j = j + 1;
                    }
                }
            }
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
// THIS CODE WAS BRUTE FORCE CODE WHICH IS VERY MASSY/CHAOS(unordered)




// //Optimized approach using interval pattern
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         // 1----3
//         // 2----6
//         // 1----6

//         // sort by start time

//         // rows -> number of intervals
//         // columns -> start, end
//         // [[1,7],[4,7]]
//         // [[1,4],[4,7]]

//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         // T: O(nlogn), S: O(n)
//         List<int[]> list = new ArrayList<>();

//         list.add(intervals[0]);

//         // [[1,4],[4,7]]
//         // list = [1,7]
//         // prev = [1,7]
//         // curr = [4,7]
//         for (int i = 1; i < intervals.length; i = i + 1) {
//             int[] prev = list.get(list.size() - 1);
//             int[] curr = intervals[i];

//             // merge ...
//             if (curr[0] <= prev[1]) {
//                 // merge
//                 prev[0] = Math.min(prev[0], curr[0]);
//                 prev[1] = Math.max(prev[1], curr[1]);
//             } else {
//                 list.add(intervals[i]);
//             }
//         }

//         int[][] res = new int[list.size()][2];
//         // list = [1,7]
//         // res = [[1,7]]
//         for (int i = 0; i < list.size(); i = i + 1) {
//             res[i] = list.get(i);
//         }

//         return res;
//     }
// }

