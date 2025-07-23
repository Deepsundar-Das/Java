import java.util.Arrays;

class Leetcode496 {

    public static void main(String[] arr) {}

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (num1 == nums2[j]) {
                    ans[i] = findGreater(num1, nums2, j + 1);
                }
            }
        }
        return ans;
    }

    private static int findGreater(int n, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            if (nums[i] > n) {
                return nums[i];
            }
        }
        return -1;
    }
}
