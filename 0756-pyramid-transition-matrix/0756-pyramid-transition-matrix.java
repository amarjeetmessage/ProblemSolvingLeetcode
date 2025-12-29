class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {

        // Step 1: Build transition map
        List<Character>[][] map = new List[6][6];
        for (String s : allowed) {
            int a = s.charAt(0) - 'A';
            int b = s.charAt(1) - 'A';
            if (map[a][b] == null) {
                map[a][b] = new ArrayList<>();
            }
            map[a][b].add(s.charAt(2));
        }

        // Memoization
        Map<String, Boolean> memo = new HashMap<>();

        return dfs(bottom, map, memo);
    }

    private boolean dfs(String row, List<Character>[][] map, Map<String, Boolean> memo) {

        // Base case: reached top
        if (row.length() == 1) return true;

        if (memo.containsKey(row)) {
            return memo.get(row);
        }

        // Generate all possible next rows
        List<String> nextRows = new ArrayList<>();
        buildNextRows(row, 0, new StringBuilder(), nextRows, map);

        for (String next : nextRows) {
            if (dfs(next, map, memo)) {
                memo.put(row, true);
                return true;
            }
        }

        memo.put(row, false);
        return false;
    }

    private void buildNextRows(
            String row,
            int idx,
            StringBuilder sb,
            List<String> result,
            List<Character>[][] map
    ) {

        if (idx == row.length() - 1) {
            result.add(sb.toString());
            return;
        }

        int a = row.charAt(idx) - 'A';
        int b = row.charAt(idx + 1) - 'A';

        if (map[a][b] == null) return;

        for (char c : map[a][b]) {
            sb.append(c);
            buildNextRows(row, idx + 1, sb, result, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
//POTD