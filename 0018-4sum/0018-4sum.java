/*
==========================================================
LeetCode 18. 4Sum

Ways to Solve
----------------------------------------------------------
1. Brute Force            -> Try all quadruplets using 4 loops.                     O(n^4)
2. 3 Loops + HashSet      -> Fix 3 numbers, HashSet finds the 4th.                 O(n^3)
3. Sort + Two Pointer ⭐   -> Fix 2 numbers, solve remaining 2Sum.                  O(n^3)
4. Pair Sum + HashMap     -> Store pair sums, search complementary pair.           O(n^2) Space O(n^2)
5. K-Sum                  -> General recursive solution for K numbers.             O(n^(k-1))

----------------------------------------------------------
Optimal Approach (Sorting + Two Pointer)

Equation

a + b + c + d = target

Fix

a
b

Remaining becomes

c + d = target - (a+b)

↓

Solve using Two Pointer.

Sort is required because

1. Two Pointer works only on sorted arrays.
2. Duplicate removal becomes easy.
==========================================================
*/

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        // Sort array
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        int n = nums.length;

        // Fix first element
        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate first element
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // Fix second element
            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate second element
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // Remaining problem is 2Sum
                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    // Use long to avoid integer overflow
                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    // Quadruplet found
                    if (sum == target) {

                        ans.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        // Move both pointers
                        left++;
                        right--;

                        // Skip duplicate third element
                        while (left < right &&
                               nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicate fourth element
                        while (left < right &&
                               nums[right] == nums[right + 1]) {
                            right--;
                        }

                    }

                    // Need larger sum
                    else if (sum < target) {

                        left++;

                    }

                    // Need smaller sum
                    else {

                        right--;

                    }
                }
            }
        }

        return ans;
    }
}

/*
----------------------------------------------------------
Complexity

Sorting        -> O(n log n)

Outer Loop     -> O(n)

Inner Loop     -> O(n)

Two Pointer    -> O(n)

Total Time     -> O(n^3)

Extra Space    -> O(1)
----------------------------------------------------------
*/