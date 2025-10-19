import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        String smallest = s;
        
        q.offer(s);
        seen.add(s);
        
        while (!q.isEmpty()) {
            String cur = q.poll();
            
            // Update smallest string
            if (cur.compareTo(smallest) < 0) {
                smallest = cur;
            }
            
            // 1️⃣ Add operation
            String addOp = addOperation(cur, a);
            if (seen.add(addOp)) {
                q.offer(addOp);
            }
            
            // 2️⃣ Rotate operation
            String rotateOp = rotateOperation(cur, b);
            if (seen.add(rotateOp)) {
                q.offer(rotateOp);
            }
        }
        
        return smallest;
    }
    
    private String addOperation(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int val = ((arr[i] - '0') + a) % 10;
            arr[i] = (char) ('0' + val);
        }
        return new String(arr);
    }
    
    private String rotateOperation(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
