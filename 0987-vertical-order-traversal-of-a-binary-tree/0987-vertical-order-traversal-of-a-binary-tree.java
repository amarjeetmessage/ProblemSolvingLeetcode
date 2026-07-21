class Solution {

    // DFS Traversal
    public void dfs(TreeNode root,
                    TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map,
                    int row,
                    int col) {

        // Base Case
        if (root == null)
            return;

        // If current column doesn't exist
        // create a new TreeMap for rows
        map.putIfAbsent(col, new TreeMap<>());

        // If current row doesn't exist
        // create a new ArrayList
        map.get(col).putIfAbsent(row, new ArrayList<>());

        // Store current node value
        map.get(col).get(row).add(root.val);

        // Visit Left
        // row increases
        // column decreases
        dfs(root.left, map, row + 1, col - 1);

        // Visit Right
        // row increases
        // column increases
        dfs(root.right, map, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // Empty Tree
        if (root == null)
            return ans;

        /*
         map

         Column
            ↓
         Row
            ↓
         List<Integer>

         */

        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map =
                new TreeMap<>();

        // Start DFS
        dfs(root, map, 0, 0);

        // Iterate over every Column
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> columnEntry
                : map.entrySet()) {

            ArrayList<Integer> vertical = new ArrayList<>();

            TreeMap<Integer, ArrayList<Integer>> rowMap =
                    columnEntry.getValue();

            // Iterate over every Row
            for (Map.Entry<Integer, ArrayList<Integer>> rowEntry
                    : rowMap.entrySet()) {

                ArrayList<Integer> nodes = rowEntry.getValue();

                // If multiple nodes have same row and column
                // sort them in ascending order
                Collections.sort(nodes);

                // Add all nodes into current vertical
                vertical.addAll(nodes);
            }

            // Store one vertical line
            ans.add(vertical);
        }

        return ans;
    }
}