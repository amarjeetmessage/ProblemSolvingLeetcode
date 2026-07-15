// class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
//         Queue<Integer> q = new LinkedList<>();

//         for(int student : students){
//             q.offer(student);
//         }

//         int stuIndex = 0;
//         int rejectCount = 0;

//         while(!q.isEmpty()){
//             if(q.peek() == sandwiches[stuIndex]){
//                 q.poll();
//                 rejectCount = 0;
//                 stuIndex++;
//             }else{
//                 rejectCount++;
//                 q.offer(q.poll());
//             }

//             if(rejectCount == q.size()){
//                 return q.size();
//             }
//         }
//         return 0;
//     }
// }




class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i<n;i++){
            if(students[i] == 0){
                count0++;
            }else count1++;
        }

        for(int i = 0; i<n; i++){
            if(sandwiches[i] == 0){
                if(count0 == 0){
                    break;
                }
                count0--;
            }
            else if(sandwiches[i] == 1){
                if(count1 == 0){
                    break;
                }
                count1--;
            }
        }

        return count0 + count1;
    }
}