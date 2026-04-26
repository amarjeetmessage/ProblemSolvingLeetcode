class Solution {
    public int largestInteger(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        // num = 1234
        // String = "1234";
        //arr = ['1','2','3','4'];


        // two loops
        for(int i = 0; i<arr.length; i++){
            int maxPos = i;
            for(int j = i+1; j<arr.length; j++){

                if(arr[j]>arr[maxPos] && (arr[i] - arr[j]) % 2 == 0){
                    maxPos = j;
                }

            }
            char temp = arr[i];
            arr[i] = arr[maxPos];
            arr[maxPos] = temp;
        }

        //finally convert modified char array into number to return int format data type
        return Integer.parseInt(new String(arr));

    }
}