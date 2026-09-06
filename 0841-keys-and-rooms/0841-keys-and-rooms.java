class Solution {

    public void bfs(int start, boolean[] vis, List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int front = q.poll();
            for(int ele : rooms.get(front)) {
                if(!vis[ele]){
                    vis[ele] = true;
                    q.add(ele);
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        // boolean visited array
        boolean[] vis = new boolean[n];// by default false in java
        vis[0] = true;
        bfs(0, vis, rooms);

        for(int i = 0; i<n; i++){
            if(vis[i] == false){
                return false;
            }
        }

        return true;

    }
}