import java.util.Arrays;

class Leetcode2411 {

    public static void main(String[] arr) {
        int[] nums = new int[] { 8, 10, 8 };
        System.out.println(Arrays.toString(smallestSubarrays(nums)));
    }

    // Brute force (extremely bad)
    public static int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];

        ans[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int target = nums[i] | nums[i + 1];
            int endIndex = binarySearch(nums, i, nums.length - 1, target);
            ans[i] = endIndex - i + 1;
        }
        // ans[nums.length - 1] = 1;
        return ans;
    }

    public static int binarySearch(int[] nums, int s, int e, int target) {
        int mid = (e - s) / 2 + s;
        while (s <= e) {
            if (nums[mid] <= target) {
                e = mid - 1;
            } else if (target < nums[mid]) return mid;
        }
        return e;
    }
}
