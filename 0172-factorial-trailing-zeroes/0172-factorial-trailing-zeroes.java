// class Solution {
//     public int findFact(int n) {
//         if (  n == 0|| n == 1) {
//             return 1;
//         }

//         int result = n * findFact(n-1);

//         return result;
//     }
//     public int trailingZeroes(int n) {
//         if(n == 0) return 0;
//         int factorial = findFact(n);
//         String str = String.valueOf(factorial);

//         int count = 0;
//         for(int i = str.length() - 1; i>0; i--) {
//             if(str.charAt(i) == '0'){
//                 count++;
//             }else{
//                 break;
//             }
//         }

//         return count;
//     }
// }



class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n > 0) {
            n = n / 5;
            count += n;
        }

        return count;
    }
}