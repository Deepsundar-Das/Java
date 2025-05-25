import java.util.*;

class Leetcode_3394 {

    public static void main(String[] ar) {
        int[][] rectangles = new int[][] {
            { 0, 2, 2, 4 },
            { 1, 0, 3, 2 },
            // { 2, 2, 3, 4 },
            // { 3, 0, 4, 2 },
            // { 3, 2, 4, 4 },
        };
        System.out.println(checkValidCuts(4, rectangles));
    }

    static boolean checkValidCuts(int n, int[][] rectangles) {
        //check for X cordinate
        int max1 = 0;
        int max2 = 0;
        int lastCordinate = 0;
        int boxNo = 0;
        int count = 0;
        int prevBoxStartingCord = -1;
        int prevBoxEndingCord = -1;
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        for (; boxNo < rectangles.length; boxNo++) {
            int curBoxStartingCord = rectangles[boxNo][0];
            int curBoxEndingCord = rectangles[boxNo][2];

            if (curBoxStartingCord >= prevBoxEndingCord) {
                count++;
                if (count == 2) break;
            } else if (
                curBoxStartingCord == prevBoxStartingCord &&
                curBoxEndingCord > prevBoxEndingCord
            ) {
                prevBoxEndingCord = curBoxEndingCord;
            } else if (
                curBoxStartingCord != prevBoxStartingCord &&
                curBoxEndingCord != prevBoxEndingCord
            ) {
                prevBoxStartingCord = curBoxStartingCord;
                prevBoxEndingCord = curBoxEndingCord;
            }
        }

        if (count >= 2) return true;
        else return false;
    }
}
