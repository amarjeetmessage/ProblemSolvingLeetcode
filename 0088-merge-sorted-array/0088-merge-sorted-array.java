class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int first = m-1;
        int second = n-1;
        int resI = m+n-1;

        while(first >= 0 && second >= 0){
            if(arr1[first] >= arr2[second]) {
                arr1[resI] = arr1[first];
                first--;
            }
            else{
                arr1[resI] = arr2[second];
                second--;
            }
        resI--;
        }
        while(second >= 0){
            arr1[resI] = arr2[second];
            second--;
            resI--;
        }
        

        
    }
}