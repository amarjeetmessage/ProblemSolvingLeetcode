import java.util.*;//POTD SOLTION NOT UNDERSTOOD 

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        TreeSet<Integer> st = new TreeSet<>(); // to store indices where we can dry (0's)
        HashMap<Integer, Integer> mp = new HashMap<>(); // lake -> last index it rained

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                st.add(i); // store zero index (dry day)
                ans[i] = 1; // default lake number to dry
            } else {
                ans[i] = -1; // raining day
                if (mp.containsKey(rains[i])) { // same lake already filled
                    Integer dryDay = st.ceiling(mp.get(rains[i])); // find next 0 after last rain
                    if (dryDay == null) {
                        return new int[0]; // no day available to dry -> flood
                    }
                    ans[dryDay] = rains[i]; // dry this lake on that day
                    st.remove(dryDay); // remove used dry day
                }
                mp.put(rains[i], i); // update lake's last rain index
            }
        }

        return ans;
    }
}
