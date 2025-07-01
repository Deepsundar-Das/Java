//what is singleton class ??
// from which class only one instance can be created.
class Singleton {

    private int a = 0;
    public static Singleton obj;

    // private Singleton() {}
    // default constructor is not mandatory
    // because new keyword will allocate memory to the object and initialize it with default values so obj will hold a memory address
    // after first time obj will not be null

    public static Singleton getInstance() {
        if (obj == null) {
            obj = new Singleton();
        }
        return obj;
    }
}
