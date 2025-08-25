

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void twoSum(int[] nums, int target, int i, int j) {
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                // avoid duplicates
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;

                result.add(Arrays.asList(-target, nums[i], nums[j]));
                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return new ArrayList<>();

        result.clear();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int n1 = nums[i];
            int target = -n1;

            twoSum(nums, target, i + 1, n - 1);
        }
        return result;
    }
}
