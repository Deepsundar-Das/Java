class StaticBlock {

    int a = 10;
    int b;

    // this is called static block, which executed only once when the class is loaded in the memory
    // for the first time, you can create thousands objects from the class but only once when
    // the class is loaded in the memory only that time the static block will be executed
    static {
        System.out.println("this block will be executed just one time");
    }

    // this is called instance block, which executed every time a new object is created
    // adv: it is useful when you want to initialize or do something for every new object
    // dis adv: you cannot pass / use parameters so it is not like treditional function , practically not useful
    // we can use constructor to instantiate / initialize (for objects it is called instanciate because you are creating a instance of a class)
    // the objects instead of instance block
    {
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock a = new StaticBlock();
        System.out.println("a = " + a.a + ", b = " + a.b);

        StaticBlock b = new StaticBlock();
        System.out.println("a = " + b.a + ", b = " + b.b);

        StaticBlock c = new StaticBlock();
        System.out.println("a = " + c.a + ", b = " + c.b);

        StaticBlock d = new StaticBlock();
        System.out.println("a = " + c.a + ", b = " + c.b);
    }
}
