class Solution {
    public String addBinary(String a, String b) {

        // StringBuilder: Used to build the result efficiently (mutable string)
        StringBuilder sb = new StringBuilder();

        // i: index for string a, starting from last character (rightmost bit)
        int i = a.length() - 1;

        // j: index for string b, starting from last character (rightmost bit)
        int j = b.length() - 1;

        // carry: to store carry over during addition, starts at 0
        int carry = 0;

        // Keep adding bits while:
        // - there are still digits left in a (i >= 0)
        // - OR digits left in b (j >= 0)
        // - OR there's still a carry left to add (carry == 1)
        while (i >= 0 || j >= 0 || carry == 1) {

            // sum: start with current carry
            int sum = carry;

            // If there are still bits left in a, add to sum
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // '0' converts char to int
                i--; // move to the next bit to the left
            }

            // If there are still bits left in b, add to sum
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // same conversion
                j--; // move to the next bit to the left
            }

            // Append the result bit to StringBuilder
            // sum % 2 gives the bit value (0 or 1)
            sb.append(sum % 2);

            // Update carry for next iteration
            // If sum is 2 or 3, carry will be 1 (binary addition)
            carry = sum / 2;
        }

        // The result is built in reverse order (LSB to MSB)
        // So reverse it to get the correct binary sum
        return sb.reverse().toString();
    }
}
