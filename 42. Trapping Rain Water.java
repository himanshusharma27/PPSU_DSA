class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int[] left = maxToLeft(height);
        int[] right = maxToRight(height);
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            totalWater += Math.min(left[i], right[i]) - height[i];
        }
        return totalWater;
    }

    public int[] maxToLeft(int[] height) {
        int[] left = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        return left;
    }

    public int[] maxToRight(int[] height) {
        int[] right = new int[height.length];
        int max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }
        return right;
    }
}
