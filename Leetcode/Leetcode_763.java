import java.util.*;

class Leetcode_763 {

    public static void main(String[] arr) {
        String s = "";
        System.out.println(Arrays.toString(partitionLabels(s)));
    }

    static ArrayList<Integer> partitionLabels(String s) {
        int startingPoint = 0;
        int endingPoint = 0;
        int stopingPoint = 0;
        char[] ch = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();

        while (stopingPoint < s.length()) {
            char findChar = ch[startingPoint];
            int currentlast = s.lastIndexOf(findChar);
            if (currentlast == s.length() - 1) {
                list.add(currentlast - startingPoint + 1);
                return list;
            }
            endingPoint = Math.max(endingPoint, currentlast);
            startingPoint++;

            while (startingPoint < currentlast) {
                findChar = ch[startingPoint];
                int lastPoint = s.lastIndexOf(findChar);
                endingPoint = Math.max(endingPoint, lastPoint);
                startingPoint++;
            }
            startingPoint++;

            list.add(endingPoint - startingPoint + 1);
            stopingPoint = endingPoint;
        }
    }
}
