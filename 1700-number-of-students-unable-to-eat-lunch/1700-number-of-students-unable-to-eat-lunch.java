class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for(int student : students){
            q.offer(student);
        }

        int stuIndex = 0;
        int rejectCount = 0;

        while(!q.isEmpty()){
            if(q.peek() == sandwiches[stuIndex]){
                q.poll();
                rejectCount = 0;
                stuIndex++;
            }else{
                rejectCount++;
                q.offer(q.poll());
            }

            if(rejectCount == q.size()){
                return q.size();
            }
        }
        return 0;
    }
}