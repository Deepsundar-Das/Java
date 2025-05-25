class Leetcode3191 {

    public static void main(String[] args) {
        int[] nums = new int[] { 0, 1, 1, 1 };
        System.out.println(minOperations(nums));
    }

    static int minOperations(int[] nums) {
        int step = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                if ((i + 2) < len) {
                    nums[i] = 1;
                    nums[i + 1] ^= 1;
                    nums[i + 2] ^= 1;
                    step++;
                } else return -1;
            }
        }
        return step;
    }
}
