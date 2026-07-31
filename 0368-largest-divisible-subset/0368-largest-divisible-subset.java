class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);

        int[] lds = new int[n];
        int[] parent = new int[n];

        Arrays.fill(lds, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int index = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (lds[i] < lds[j] + 1) {
                        lds[i] = lds[j] + 1;
                        parent[i] = j;
                    }
                }
            }

            if (lds[i] > maxLen) {
                maxLen = lds[i];
                index = i;
            }
        }

        List<Integer> answer = new ArrayList<>();

        while (index != -1) {
            answer.add(nums[index]);
            index = parent[index];
        }

        Collections.reverse(answer);
        return answer;
    }
}