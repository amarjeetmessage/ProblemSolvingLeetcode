class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
         HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                int mask = map.getOrDefault(row, 0);

                mask |= (1 << (col - 2));

                map.put(row, mask);
            }
        }
         int answer = (n - map.size()) * 2;

        for (int mask : map.values()) {

           
            int left = 0b00001111;

            int middle = 0b00111100;

           
            int right = 0b11110000;

            boolean canLeft = (mask & left) == 0;
            boolean canMiddle = (mask & middle) == 0;
            boolean canRight = (mask & right) == 0;

            if (canLeft && canRight) {
                
                answer += 2;
            } else if (canLeft || canMiddle || canRight) {
                
                answer += 1;
            }
        }

        return answer;
    }
}//potd