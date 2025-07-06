class WrapperClass {

    public static void main(String[] arr) {
        /*
        The Integer class, like other wrapper classes (e.g., Long, Double, Boolean),
        is designed to be immutable. This means that once an Integer object is created,
        its value cannot be changed.
        When you perform operations like x++ on an Integer object, Java doesn't modify the original object.
        Instead, it creates a new Integer object with the new value
        */
        Integer a = 10;
        Integer b = 20;
        changeValue(a, b);
        System.out.println("a= " + a + ", b=" + b);
    }

    /*
    what is happening here ????
    => what I understand,
        let memory addresses of 'a' and 'b' are S100 and S200 (in stack memory)
        in heap memory let say two addresses are H101 and H201 where 10 and 20 is present and 100 and 200 are pointing to them
        now when I passed value of 'a' and 'b' in the changeValue it created another memory like S300 and S400
        and refer the memory to H101 and H201 in heap
        eg :
         S100 --> H101 --> 10 and S200 --> H201 --> 20
         S300 --> H101 --> 10 and S400 --> H201 --> 20

         now these S300 and S400 are passed so any out of the scope the function actual value of 'a' and 'b' are not changed

         and if I try to change the value of a in tht changeValue function as Integer is final(immutable) class this will create
        another object in heap it will point to that object
    */
    static void changeValue(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
    }
}
