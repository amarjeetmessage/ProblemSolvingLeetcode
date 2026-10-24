class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int aliceArrive = convert(arriveAlice, days);
        int aliceLeave = convert(leaveAlice, days);

        int bobArrive = convert(arriveBob, days);
        int bobLeave = convert(leaveBob, days);

        int start = Math.max(aliceArrive, bobArrive);
        int end = Math.min(aliceLeave, bobLeave);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    public int convert(String str, int[] days) {
        int month = Integer.parseInt(str.substring(0, 2));
        int date = Integer.parseInt(str.substring(3, 5));

        int total = date;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }
}