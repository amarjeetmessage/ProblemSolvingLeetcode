class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0; // initial value of X is 0

        for (String op : operations) {
            if (op.contains("++")) {
                X++; // increment if operation is ++X or X++
            } else {
                X--; // decrement if operation is --X or X--
            }
        }

        return X; // return final value
    }
}
