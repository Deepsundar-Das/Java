import java.util.*;

class Leetcode594 {

    public static void main(String[] ar) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(findLHS(nums));
    }

    static int findLHS(int[] nums) {
        int max = 0;
        int countItem1 = 0;
        int countItem2 = 0;
        boolean item1 = false;
        boolean item2 = true;
        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if (!item1) {
                    countItem1 = count;
                } else {
                    countItem2 = count;
                }
                if (countItem1 + countItem2 > max) max =
                    countItem1 + countItem2;
                item2 = !item2;
                item1 = !item1;
                count = 1;
            }
            count++;
        }

        return max;
    }
}
