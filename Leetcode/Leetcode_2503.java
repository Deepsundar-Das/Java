import java.util.Arrays;

class Leetcode_2503 {

    public static void main(String[] ar) {
        int[][] grid = new int[][] { { 1, 2, 3 }, { 2, 5, 7 }, { 3, 5, 1 } };
        int[] queries = new int[] { 5, 6, 2 };
        int[] answer = new int[queries.length];
        answer = maxPoints(grid, queries);
        System.out.println(Arrays.toString(answer));
    }

    static int[] maxPoints(int[][] grid, int[] queries) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int i = 0;
        int[] answer = new int[queries.length];
        for (int q : queries) {
            answer[i] = doRecursion(grid, 0, 0, rowLen, colLen, q);
            i++;
        }
        return answer;
    }

    static int doRecursion(
        int[][] grid,
        int row,
        int col,
        int rowLen,
        int colLen,
        int query
    ) {
        if ((rowLen - 1) == row && (colLen - 1) == col) return 0;
        if (grid[row][col] < query) {
            return (
                1 +
                doRecursion(grid, row, col + 1, rowLen, colLen, query) +
                doRecursion(grid, row + 1, col, rowLen, colLen, query)
            );
        } else return 0;
    }
}
