class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0; // devices in previous non-empty row
        int totalBeams = 0;

        for (String row : bank) {
            int curr = 0;
            // count number of devices ('1')
            for (char c : row.toCharArray()) {
                if (c == '1') curr++;
            }

            // if current row has devices
            if (curr > 0) {
                totalBeams += prev * curr; // connect with previous
                prev = curr; // update previous
            }
        }
        return totalBeams;
    }
}
