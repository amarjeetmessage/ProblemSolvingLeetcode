class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freqArr[] = new int[101];//101 because give in constraint that size max possible is 100
        int maxFreq = 0;
        int sumFreq = 0;

        for(int element : nums){
            freqArr[element]++;
            int currFreq = freqArr[element];

            if(currFreq > maxFreq){
                maxFreq = currFreq;
                sumFreq = currFreq;
            }else if(currFreq == maxFreq){
                sumFreq += currFreq;
            }
        }
        return sumFreq;
    }
}