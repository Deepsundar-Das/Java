class Generics {

    public static void main(String[] arr) {
        Integer a = 10;
        Integer b = 20;
        changeValue(a, b);
        System.out.println("a= " + a + ", b=" + b);
    }

    static void changeValue(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}
