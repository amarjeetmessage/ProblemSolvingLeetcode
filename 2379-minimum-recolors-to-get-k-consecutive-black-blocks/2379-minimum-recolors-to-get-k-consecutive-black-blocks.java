class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        //first window
        int countW = 0;
        for(int i = 0; i<k; i++){
            if(blocks.charAt(i) == 'W') {
                countW++;
            }
        }

        int min = countW;
        int i = 0;
        int j = k;

        //sliding 
        while(j < n){
            if(blocks.charAt(j) == 'W'){
                countW++;
            }
            if(blocks.charAt(i) == 'W'){
                countW--;
            }

            min = Math.min(min,countW);
            i++;
            j++;
        }
        return min;
    }
}