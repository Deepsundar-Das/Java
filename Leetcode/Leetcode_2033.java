import java.util.Arrays;

class Leetcode_2033 {

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 2, 4 }, { 6, 8 } };
        System.out.println(minOperations(grid, 1));
    }

    static int minOperations(int[][] grid, int x) {
        int sum = 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[] arr = new int[rowLen * colLen];
        int indexCounter = 0;
        int mid = (rowLen * colLen) / 2;

        for (int[] i : grid) {
            for (int j : i) {
                arr[indexCounter] = j;
                indexCounter++;
            }
        }

        Arrays.sort(arr);
        if ((rowLen * colLen) % 2 == 0) {
            int choice1 = arr[mid];
            int choice2 = arr[mid - 1];
            int max1 = Math.max(
                choice1 - arr[0],
                choice1 - arr[arr.length - 1]
            );
            int max2 = Math.max(
                choice2 - arr[0],
                Math.abs(choice2 - arr[arr.length - 1])
            );
            if (max1 > max2) mid = mid - 1;
        }

        int middle = arr[mid];
        for (int i : arr) {
            if ((middle - i) % x == 0) {
                int diff = (middle - i) / x;
                sum += Math.abs(diff);
            } else return -1;
        }
        return sum;
    }
}
