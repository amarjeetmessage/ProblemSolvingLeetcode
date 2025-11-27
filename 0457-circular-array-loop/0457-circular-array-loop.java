class Solution {

    // This function calculates the next index based on circular movement
    public int calcNextIdx(int[] nums, int curr) {
        int next = curr;             // store current index
        int seq = nums[curr];        // steps to move

        if (seq > 0) {  // positive movement => move forward
            // Simple forward movement with wrap around
            next = (next + seq) % nums.length;
        } else { // negative movement => move backward
            // In Java: -ve % n gives -ve number => so we adjust
            // Example: -5 % 8 = -5 → move forward by (8 - 5) = 3 steps
            int mod = seq % nums.length;  // still negative
            int forward = nums.length + mod; // convert negative to forward movement
            next = (curr + forward) % nums.length; // correct circular index
        }

        return next; // return next index in circular array
    }


    public boolean circularArrayLoop(int[] nums) {
        // Loop must be : length > 1 AND same direction movement

        // Try starting from each index
        for (int i = 0; i < nums.length; i++) {

            boolean isForward = nums[i] > 0; // direction for this run
            int slow = i; // slow pointer for Floyd Cycle
            int fast = i; // fast pointer for Floyd Cycle

            // Using Floyd cycle detection
            while (true) {

                // Move slow pointer by 1 step
                slow = calcNextIdx(nums, slow);

                // Move fast pointer by 2 steps
                fast = calcNextIdx(nums, fast);
                fast = calcNextIdx(nums, fast);

                // If direction changes => invalid loop → break
                // OR we land on a visited path marked as zero
                if ((nums[slow] > 0) != isForward || (nums[fast] > 0) != isForward) {
                    break;
                }

                // If both meet => cycle found
                if (slow == fast) {
                    // But cycle of 1 element NOT ALLOWED => break
                    if (slow == calcNextIdx(nums, slow)) {
                        break;
                    }
                    return true; // valid cycle found
                }
            }
        }

        // No valid loop found anywhere
        return false;
    }
}