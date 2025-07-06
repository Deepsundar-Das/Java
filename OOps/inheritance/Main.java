class Main {

    static {
        System.out.println("Hello Universe");
    }

    {
        System.out.println("I am in instance block");
    }

    public static void main(String[] ar) {
        Main m = new Main();
        Main n = new Main();
        Main o = new Main();
    }
}
