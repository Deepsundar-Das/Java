import java.util.*;

class GameOfTwoStack {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();
        a.add(4);
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(1);
        b.add(2);
        b.add(1);
        b.add(8);
        b.add(5);
        System.out.println(twoStacks(10, a, b));
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        return helper(maxSum, a, b, 0, 0, 0, 0);
    }

    //4 2 4 6 1
    // 2 1 8 5

    public static int helper(
        int maxSum,
        List<Integer> a,
        List<Integer> b,
        int sum,
        int count,
        int i,
        int j
    ) {
        int left = 0;
        int right = 0;
        if (sum > maxSum) return count;
        else if (a.isEmpty() && b.isEmpty()) return count;
        else if (b.isEmpty()) {
            left = helper(maxSum, a, b, sum += a.get(i), count + 1, ++i, j);
        } else if (a.isEmpty()) {
            right = helper(maxSum, a, b, sum += b.get(j), count + 1, i, ++j);
        } else {
            left = helper(maxSum, a, b, sum += a.get(i), count + 1, ++i, j);
            right = helper(maxSum, a, b, sum += b.get(j), count + 1, i, ++j);
        }
        return Math.max(left, right);
    }
}
