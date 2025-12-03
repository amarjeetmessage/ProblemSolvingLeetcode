class Solution {

    private int gcd(int a, int b) {
        if (b == 0) return Math.abs(a);
        return gcd(b, a % b);
    }

    // Check if 4 points form a convex quadrilateral
    private boolean isConvex(int[][] p) {

        // Compute centroid
        double cx = 0, cy = 0;
        for (int[] a : p) {
            cx += a[0];
            cy += a[1];
        }
        cx /= 4;
        cy /= 4;

        // Java lambda needs final variables
        final double fcx = cx, fcy = cy;

        // Sort by angle around the centroid
        Arrays.sort(p, (a, b) -> {
            double angA = Math.atan2(a[1] - fcy, a[0] - fcx);
            double angB = Math.atan2(b[1] - fcy, b[0] - fcx);
            return Double.compare(angA, angB);
        });

        // Check convexity using consistent cross product sign
        int prev = 0;
        for (int i = 0; i < 4; i++) {
            int[] A = p[i];
            int[] B = p[(i + 1) % 4];
            int[] C = p[(i + 2) % 4];

            long x1 = B[0] - A[0];
            long y1 = B[1] - A[1];
            long x2 = C[0] - B[0];
            long y2 = C[1] - B[1];

            long cross = x1 * y2 - y1 * x2;
            if (cross == 0) return false; // collinear → not convex

            int s = (cross > 0 ? 1 : -1);
            if (prev == 0) prev = s;
            else if (prev != s) return false;  // sign breaks → not convex
        }

        return true;
    }

    public int countTrapezoids(int[][] points) {

        int n = points.length;

        // Slope → list of segments (two point indices)
        Map<String, List<int[]>> map = new HashMap<>();

        // Build all segments with normalized slope
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0) {
                    map.computeIfAbsent("inf", k -> new ArrayList<>()).add(new int[]{i, j});
                } else {
                    int g = gcd(dx, dy);
                    dx /= g;
                    dy /= g;

                    // Normalize slope direction
                    if (dx < 0) { dx = -dx; dy = -dy; }

                    String key = dx + "," + dy;
                    map.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
                }
            }
        }

        int ans = 0;

        // For every slope group → choose pairs of disjoint segments
        for (List<int[]> segs : map.values()) {
            int m = segs.size();

            for (int a = 0; a < m; a++) {
                for (int b = a + 1; b < m; b++) {

                    int[] s1 = segs.get(a);
                    int[] s2 = segs.get(b);

                    int p1 = s1[0], p2 = s1[1];
                    int p3 = s2[0], p4 = s2[1];

                    // Segments must use 4 different endpoints
                    if (p1 == p3 || p1 == p4 || p2 == p3 || p2 == p4) continue;

                    // Build candidate quadrilateral
                    int[][] quad = {
                            points[p1],
                            points[p2],
                            points[p3],
                            points[p4]
                    };

                    // Convexity check
                    if (isConvex(quad)) ans++;
                }
            }
        }

        return ans;
    }
}

//POTD