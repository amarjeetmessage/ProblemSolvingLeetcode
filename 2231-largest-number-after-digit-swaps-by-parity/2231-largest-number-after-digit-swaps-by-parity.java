// class Solution {
//     public int largestInteger(int num) {
//         char[] arr = String.valueOf(num).toCharArray();
//         // num = 1234
//         // String = "1234";
//         //arr = ['1','2','3','4'];


//         // two loops
//         for(int i = 0; i<arr.length; i++){
//             int maxPos = i;
//             for(int j = i+1; j<arr.length; j++){

//                 if(arr[j]>arr[maxPos] && (arr[i] - arr[j]) % 2 == 0){
//                     maxPos = j;
//                 }

//             }
//             char temp = arr[i];
//             arr[i] = arr[maxPos];
//             arr[maxPos] = temp;
//         }

//         //finally convert modified char array into number to return int format data type
//         return Integer.parseInt(new String(arr));

//     }
// }







class Solution {
    public int largestInteger(int num) {
        //even digits
        //odd digits
        //num.... digit ... scan.... heaps
        //<1234>
        // < 2 , 4> < 1, 3 >
        // scan. 1234
        //add max of even digit and odd digit 

        PriorityQueue<Integer> pqEven = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqOdd = new PriorityQueue<>(Collections.reverseOrder());

        char[] arr = String.valueOf(num).toCharArray();

        for(int i = 0; i<arr.length; i++){
            if((arr[i] - '0') % 2 == 0){
                pqEven.offer(arr[i] - '0');
            }else{
                pqOdd.offer(arr[i] - '0');
            }
        }

        //"1234"
        // < 1,3> < 2, 4>

        StringBuilder sb = new StringBuilder();

        for(char c : arr) {
            int val = c - '0';
            if(val % 2 == 0){
                sb.append(pqEven.poll());
            }else{
                sb.append(pqOdd.poll());
            }
        }

        return Integer.parseInt(sb.toString());

    }
}