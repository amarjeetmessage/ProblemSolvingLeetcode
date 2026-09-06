class Solution {

    public void bfs(int i , boolean[] vis, int[][] isConnected){
        int n = isConnected.length; 
        Queue<Integer> q = new LinkedList<>();

        q.add(i);

        while(q.size() > 0) {
            int front = q.poll();
            for(int j = 0; j<n; j++){
                if(isConnected[front][j] == 1 && vis[j] == false){
                    q.offer(j);
                    vis[j] = true;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;

        boolean[] vis = new boolean[n];// by default false

        for(int i = 0; i<n; i++) {
            if(!vis[i]){
                bfs(i, vis, isConnected);
                count++;
            }
        }


        return count;
    }
}