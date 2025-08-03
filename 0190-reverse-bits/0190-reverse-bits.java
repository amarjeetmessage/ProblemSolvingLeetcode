class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i< 32; i++){
            int lsb = n & 1;
            int reverseLsb = lsb << (31 - i );
            result = result | reverseLsb;
            n = n >> 1;
        }
        return result;
    }
}

//unsingned means which can not be negative 


// class Solution {
//     public int reverseBits(int n) {

//         // Step 1: Initialize result to store reversed number
//         int result = 0;

//         // Step 2: Process all 32 bits one by one
//         for (int i = 0; i < 32; i++) {

//             // Step 3: Get the last bit (Least Significant Bit - LSB)
//             // n & 1 se last bit milta hai
//             int lsb = n & 1;

//             // Step 4: Shift this bit to its reversed position
//             // Agar bit abhi i-th position pe hai to usko (31 - i) position pe bhejna hai
//             int reverseLsb = lsb << (31 - i);

//             // Step 5: Merge shifted bit with result
//             // result mein OR karke add kar dete hain taaki pehle se jo bit hai woh bhi rahe
//             result = result | reverseLsb;

//             // Step 6: Shift n right by 1 to process next bit
//             // Next LSB ke liye right shift kar diya
//             n = n >> 1;
//         }

//         // Step 7: Return final reversed bits number
//         return result;
//     }
// }
