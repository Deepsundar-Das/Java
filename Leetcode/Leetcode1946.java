class Leetcode1946 {

    public static void main(String[] aa) {
        String num = "5";
        int[] change = { 9, 8, 5, 0, 3, 6, 4, 2, 6, 8 };
        System.out.println(maximumNumber(num, change));
    }

    static String maximumNumber(String num, int[] change) {
        int numInt = Integer.parseInt(num);
        int sizeOfNum = num.length();
        char[] s = num.toCharArray();
        int[] digit = new int[sizeOfNum];
        for (int i = 0; i < sizeOfNum; i++) {
            digit[i] = s[i] - '0';
        }

        for (int i = 0; i < sizeOfNum; i++) {
            String str =
                num.substring(0, i) +
                (char) change[digit[i]] +
                num.substring(i + 1);
            int backToInt = Integer.parseInt(str);
            if (numInt < backToInt) break;
            numInt = backToInt;
        }

        return Integer.toString(numInt);
    }
}
