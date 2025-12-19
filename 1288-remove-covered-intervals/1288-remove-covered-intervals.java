class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
       /*count
       or i = 0 to end
          for(j = 0 to end)
            /if(j interval covers i) {
                count ++ ;
            } 
        return count;
        */

        int count = 0;
        for(int i = 0; i < intervals.length; i++) {
            int c = intervals[i][0],
                d = intervals[i][1];

            boolean isCovered = false;
            for(int j = 0; j< intervals.length; j++) {
                int a = intervals[j][0],
                    b = intervals[j][1];

                    if( i != j && (a <= c && b >= d)) {
                        isCovered = true;
                        break;
                    }
            }
            if(!isCovered) {
                count++;
            }
        }
        return count;
    }
}