class Solution {
    public int countTriples(int n) {
        int count = 0;
        
        // c is the hypotenuse
        for (int c = 1; c <= n; c++) {
            int c2 = c * c;
            // a is one leg
            for (int a = 1; a <= n; a++) {
                int a2 = a * a;
                int b2 = c2 - a2;
                if (b2 <= 0) continue;
                
                int b = (int) Math.sqrt(b2);
                if (b <= n && b * b == b2) {
                    count++;
                }
            }
        }
        return count;
    }
}
